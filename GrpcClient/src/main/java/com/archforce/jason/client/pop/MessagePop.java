package com.archforce.jason.client.pop;

import com.archforce.ath.rds.grpc.proto.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by zh_w5 on 2020/12/30.
 */
@Component
@Slf4j
public class MessagePop {

  private static final ClientManageGrpc.ClientManageStub clientManageStub;

  static {
    ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 6561).usePlaintext().build();
    clientManageStub = ClientManageGrpc.newStub(managedChannel);
  }


  @PostConstruct
  public void loginToServer() {
    log.info("login to server...");
    ClientInfo clientInfo = ClientInfo.newBuilder().setClientId("1").setUsername("jason").setPassword("123456").build();
    clientManageStub.loginToServer(clientInfo, new StreamObserver<Message>() {
      @Override
      public void onNext(Message message) {

      }

      @Override
      public void onError(Throwable throwable) {

      }

      @Override
      public void onCompleted() {

      }
    });
  }

  @PreDestroy
  public void logoutFromServer() {
    log.info("logout from server...");
    ClientInfo clientInfo = ClientInfo.newBuilder().setClientId("1").setUsername("jason").setPassword("123456").build();
    clientManageStub.logoutFromServer(clientInfo, new StreamObserver<Message>() {
      @Override
      public void onNext(Message message) {

      }

      @Override
      public void onError(Throwable throwable) {

      }

      @Override
      public void onCompleted() {

      }
    });
  }

  public void receive() {
    ClientInfo clientInfo = ClientInfo.newBuilder().setClientId("1").setUsername("jason").setPassword("123456").build();
    clientManageStub.sendMsg(clientInfo, new StreamObserver<Message>() {
      @Override
      public void onNext(Message message) {
        log.info("receive message[" + message + "].");
      }

      @Override
      public void onError(Throwable throwable) {

      }

      @Override
      public void onCompleted() {

      }
    });
  }
}
