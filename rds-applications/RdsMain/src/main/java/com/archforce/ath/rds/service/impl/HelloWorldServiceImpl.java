package com.archforce.ath.rds.service.impl;

import com.archforce.ath.rds.grpc.proto.*;
import com.archforce.ath.rds.service.HelloWorldService;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
@Slf4j
public class HelloWorldServiceImpl extends HelloWorldServiceGrpc.HelloWorldServiceImplBase implements HelloWorldService {

  private final static Set<StreamObserver<Greeting>> observers = new LinkedHashSet<>();
  private final static Set<StreamObserver<Greeting>> observers1 = new LinkedHashSet<>();

  @Override
  public void sayHelloByStream(A3 request, StreamObserver<Greeting> responseObserver) {
    String clientId = UUID.randomUUID().toString().replaceAll("-", "");
    observers.add(responseObserver);
    log.info("sayHelloByStream 远程客户端[" + clientId + "]已连接");
  }

  @Override
  public void sayHelloByStream1(A3 request, StreamObserver<Greeting> responseObserver) {
    String clientId = UUID.randomUUID().toString().replaceAll("-", "");
    observers1.add(responseObserver);
    log.info("sayHelloByStream1 远程客户端[" + clientId + "]已连接");
  }

  @Override
  public void sayHello(Person request, StreamObserver<Greeting> responseObserver) {
    String result = request.getFirstName() + "-" + request.getLastName();
    Greeting greeting = Greeting.newBuilder().setMessage(result).build();
    responseObserver.onNext(greeting);
    responseObserver.onCompleted();
  }

  @Override
  public void addOperation(A1 request, StreamObserver<A2> responseObserver) {
    int a = request.getA();
    int b = request.getB();
    A2 a2 = A2.newBuilder().setMessage(a + b).build();
    responseObserver.onNext(a2);
    responseObserver.onCompleted();
  }

  @Override
  public void addOperation1(A3 request, StreamObserver<A2> responseObserver) {
    List<Integer> numbers = request.getIList();
    int result = 0;
    for (Integer number : numbers) {
      result += number;
    }
    A2 a2 = A2.newBuilder().setMessage(result).build();
    responseObserver.onNext(a2);
    responseObserver.onCompleted();
  }

  @Override
  public void sayHello(String message) {
    Greeting greeting = Greeting.newBuilder().setMessage(message).build();
    for (StreamObserver<Greeting> observer : observers) {
      try {
        observer.onNext(greeting);
      } catch (Exception e) {
        log.error("send message failed!", e);
      }
    }
//    observers.forEach(o -> o.onNext(greeting));
  }

  @Override
  public void sayHello1(String message) {
    Greeting greeting = Greeting.newBuilder().setMessage(message).build();
    for (StreamObserver<Greeting> observer : observers1) {
      try {
        observer.onNext(greeting);
      } catch (Exception e) {
        log.error("send message failed!", e);
      }
    }
//    observers.forEach(o -> o.onNext(greeting));
  }
}
