package com.archforce.ath.rds.service.impl;

import com.archforce.ath.rds.grpc.proto.*;
import com.archforce.ath.rds.service.HelloWorldService;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.stereotype.Service;

import java.util.List;

@GrpcService
@Service
@Slf4j
public class HelloWorldServiceImpl extends HelloWorldServiceGrpc.HelloWorldServiceImplBase implements HelloWorldService {

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
}
