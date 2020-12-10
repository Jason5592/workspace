package cn.wuyuanwei;

import cn.wuyuanwei.PingPongProto.Ping;
import cn.wuyuanwei.PingPongProto.Pong;
import cn.wuyuanwei.PingPongServiceGrpc.PingPongServiceImplBase;
import io.grpc.Server;
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;
import io.grpc.netty.shaded.io.netty.channel.ChannelOption;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class PingPongServer {

  static class PingPongImpl extends PingPongServiceImplBase {
    @Override
    public void pingPong(Ping request, StreamObserver<Pong> responseObserver) {
      Pong response = Pong.newBuilder().setMsg("Pong!").build();
      responseObserver.onNext(response);
      responseObserver.onCompleted();
    }
  }

  public static void main(String[] args) throws IOException, InterruptedException {
    int port = 50050;
    Server server = NettyServerBuilder.forPort(port).withChildOption(ChannelOption.TCP_NODELAY, true).addService(new PingPongImpl()).build();

    Runtime.getRuntime().addShutdownHook(new Thread(() -> {
      System.err.println("*** Shutting down ping-pong gRPC server");
      try {
        server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.err.println("*** ping-pong gPRC server shut down");
    }));

    server.start();
    System.out.println("ping-pong gRPC server started, listening on " + port);
    server.awaitTermination();
  }

}
