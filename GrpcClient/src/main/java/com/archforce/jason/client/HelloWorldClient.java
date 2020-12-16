package com.archforce.jason.client;

import com.archforce.jason.grpc.proto.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class HelloWorldClient {

    private static final HelloWorldServiceGrpc.HelloWorldServiceBlockingStub helloWorldServiceBlockingStub;

    static {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 6561).usePlaintext().build();
        helloWorldServiceBlockingStub = HelloWorldServiceGrpc.newBlockingStub(managedChannel);
    }

    public String sayHello(String firstName, String lastName) {
        Person person = Person.newBuilder().setFirstName(firstName).setLastName(lastName).build();
        log.info("client sending {}", person);

        Greeting greeting = helloWorldServiceBlockingStub.sayHello(person);
        log.info("client received {}", greeting);

        return greeting.getMessage();
    }

    public int addOperation(int a, int b) {
        A1 a1 = A1.newBuilder().setA(a).setB(b).build();
        A2 a2 = helloWorldServiceBlockingStub.addOperation(a1);
        return a2.getMessage();
    }

    public int addOperation1(List<Integer> numbers) {
        A3 a3 = A3.newBuilder().addAllI(numbers).build();
        A2 a2 = helloWorldServiceBlockingStub.addOperation1(a3);
        return a2.getMessage();
    }

    @Test
    public void test1() {
        HelloWorldClient helloWorldClient = new HelloWorldClient();
        String result = helloWorldClient.sayHello("wang", "jason");
        System.out.println(result);
    }

    @Test
    public void test2() {
        HelloWorldClient helloWorldClient = new HelloWorldClient();
        int a = 1;
        int b = 2;
        int result = helloWorldClient.addOperation(a, b);
        System.out.println(result);
    }

    @Test
    public void test3() {
        HelloWorldClient helloWorldClient = new HelloWorldClient();
        int result = helloWorldClient.addOperation1(Arrays.asList(1, 2, 3));
        System.out.println(result);
    }
}
