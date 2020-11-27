package cn.wuyuanwei;

import cn.wuyuanwei.PingPongProto.Ping;
import cn.wuyuanwei.PingPongProto.Pong;
import cn.wuyuanwei.PingPongServiceGrpc.PingPongServiceBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class PingPongClient {

  public static void main(String[] args) {
    ManagedChannel channel = ManagedChannelBuilder.forAddress("127.0.0.1", 50050).usePlaintext().build();
    PingPongServiceBlockingStub stub = PingPongServiceGrpc.newBlockingStub(channel);
    String ping = "Ping!";
    for (int i = 0; i < 10; ++i) {
      System.out.println(ping);
      Pong pong = stub.pingPong(Ping.newBuilder().setMsg(ping).build());
      System.out.println(pong.getMsg());
    }
  }

}
