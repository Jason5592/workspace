package com.archforce.jason.grpc;

import com.google.common.util.concurrent.UncaughtExceptionHandlers;
import io.grpc.ServerBuilder;
import io.grpc.netty.NettyServerBuilder;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.ServerChannel;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.concurrent.DefaultThreadFactory;
import lombok.extern.slf4j.Slf4j;
import org.lognet.springboot.grpc.GRpcServerBuilderConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.net.InetSocketAddress;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinWorkerThread;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@Slf4j
public class RDSGRpcServerBuilderConfigurer extends GRpcServerBuilderConfigurer {

    @Value("${grpc.hostname}")
    private String hostname;
    @Value("${grpc.port}")
    private int port;
    /**
     * 0-NETTY_NIO 1-NETTY_EPOLL 2-NETTY_UNIX_DOMAIN_SOCKET
     */
    @Value("${grpc.server.transport}")
    private int transport;
    /**
     * 0-关闭tls 1-打开tls
     */
    @Value("${grpc.server.tls}")
    private int tls;
    @Value("${grpc.security.cert}")
    private String certChain;
    @Value("${grpc.security.key}")
    private String privateKey;
    /**
     * directExecutor=1:
     * Don't use a ThreadPool for RPC calls, instead execute calls directly in the transport thread
     */
    @Value("${grpc.server.direct.executor}")
    private int directExecutor;

    @Override
    public void configure(ServerBuilder<?> serverBuilder) {
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
                    Class<?> groupClass = Class.forName("io.netty.channel.epoll.EpollEventLoopGroup");
                    @SuppressWarnings("unchecked")
                    Class<? extends ServerChannel> channelClass = (Class<? extends ServerChannel>)
                            Class.forName("io.netty.channel.epoll.EpollServerSocketChannel");
                    boss = (EventLoopGroup) groupClass.getConstructor(int.class, ThreadFactory.class).newInstance(1, tf);
                    worker = (EventLoopGroup) groupClass.getConstructor(int.class, ThreadFactory.class).newInstance(0, tf);
                    channelType = channelClass;
                    break;
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            case 2: {
                try {
                    // These classes are only available on linux.
                    Class<?> groupClass = Class.forName("io.netty.channel.epoll.EpollEventLoopGroup");
                    @SuppressWarnings("unchecked")
                    Class<? extends ServerChannel> channelClass = (Class<? extends ServerChannel>)
                            Class.forName("io.netty.channel.epoll.EpollServerDomainSocketChannel");
                    boss = (EventLoopGroup) groupClass.getConstructor(int.class, ThreadFactory.class).newInstance(1, tf);
                    worker = (EventLoopGroup) groupClass.getConstructor(int.class, ThreadFactory.class).newInstance(0, tf);
                    channelType = channelClass;
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

        serverBuilder = NettyServerBuilder
                .forAddress(InetSocketAddress.createUnresolved(hostname, port))
                .bossEventLoopGroup(boss)
                .workerEventLoopGroup(worker)
                .channelType(channelType);
        if (tls == 1) {
            log.info("Using fake CA for TLS certificate. Run the Java client with --tls");
            File cert = new File(certChain);
            File key = new File(privateKey);
            serverBuilder.useTransportSecurity(cert, key);
        }
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
        serverBuilder.build();
    }
}
