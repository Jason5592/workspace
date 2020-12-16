package com.archforce.ath.rds.grpc;

import com.google.common.util.concurrent.UncaughtExceptionHandlers;
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;
import io.grpc.netty.shaded.io.netty.channel.EventLoopGroup;
import io.grpc.netty.shaded.io.netty.channel.ServerChannel;
import io.grpc.netty.shaded.io.netty.channel.epoll.EpollEventLoopGroup;
import io.grpc.netty.shaded.io.netty.channel.epoll.EpollServerDomainSocketChannel;
import io.grpc.netty.shaded.io.netty.channel.epoll.EpollServerSocketChannel;
import io.grpc.netty.shaded.io.netty.channel.nio.NioEventLoopGroup;
import io.grpc.netty.shaded.io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.concurrent.DefaultThreadFactory;
import net.devh.boot.grpc.server.serverfactory.GrpcServerConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinWorkerThread;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Configuration
public class GrpcServerConfig {

    /**
     * 0-NETTY_NIO 1-NETTY_EPOLL 2-NETTY_UNIX_DOMAIN_SOCKET
     */
    @Value("${grpc.server.transport}")
    private int transport;
    /**
     * directExecutor=1:
     * Don't use a ThreadPool for RPC calls, instead execute calls directly in the transport thread
     */
    @Value("${grpc.server.direct.executor}")
    private int directExecutor;

    @Bean
    public GrpcServerConfigurer grpcServerConfigurer() {
        final EventLoopGroup boss;
        final EventLoopGroup worker;
        final Class<? extends ServerChannel> channelType;
        ThreadFactory tf = new DefaultThreadFactory("server-elg-", true /*daemon */);
        switch (transport) {
            case 0: {
                boss = new NioEventLoopGroup(1, tf);
                worker = new NioEventLoopGroup(0, tf);
                channelType = NioServerSocketChannel.class;
                break;
            }
            case 1: {
                try {
                    // These classes are only available on linux.
                    boss = new EpollEventLoopGroup(1, tf);
                    worker = new EpollEventLoopGroup(0, tf);
                    channelType = EpollServerSocketChannel.class;
                    break;
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            case 2: {
                try {
                    // These classes are only available on linux.
                    boss = new EpollEventLoopGroup(1, tf);
                    worker = new EpollEventLoopGroup(0, tf);
                    channelType = EpollServerDomainSocketChannel.class;
                    break;
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            default: {
                // Should never get here.
                throw new IllegalArgumentException("Unsupported transport: " + transport);
            }
        }

        return serverBuilder -> {
            if (serverBuilder instanceof NettyServerBuilder) {
                ((NettyServerBuilder) serverBuilder)
                        .bossEventLoopGroup(boss)
                        .workerEventLoopGroup(worker)
                        .channelType(channelType)
                        .keepAliveTime(30, TimeUnit.SECONDS)
                        .keepAliveTimeout(5, TimeUnit.SECONDS)
                        .permitKeepAliveWithoutCalls(true);
                if (directExecutor == 1) {
                    serverBuilder.directExecutor();
                } else {
                    // TODO(carl-mastrangelo): This should not be necessary.  I don't know where this should be
                    // put.  Move it somewhere else, or remove it if no longer necessary.
                    // See: https://github.com/grpc/grpc-java/issues/2119
                    serverBuilder.executor(new ForkJoinPool(Runtime.getRuntime().availableProcessors(),
                            new ForkJoinPool.ForkJoinWorkerThreadFactory() {
                                final AtomicInteger num = new AtomicInteger();

                                @Override
                                public ForkJoinWorkerThread newThread(ForkJoinPool pool) {
                                    ForkJoinWorkerThread thread =
                                            ForkJoinPool.defaultForkJoinWorkerThreadFactory.newThread(pool);
                                    thread.setDaemon(true);
                                    thread.setName("grpc-server-app-" + "-" + num.getAndIncrement());
                                    return thread;
                                }
                            }, UncaughtExceptionHandlers.systemExit(), true /* async */));
                }
            }
        };
    }
}
