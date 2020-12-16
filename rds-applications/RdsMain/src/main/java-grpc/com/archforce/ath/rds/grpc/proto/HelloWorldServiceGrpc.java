package com.archforce.ath.rds.grpc.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.16.1)",
    comments = "Source: HelloWorld.proto")
public final class HelloWorldServiceGrpc {

  private HelloWorldServiceGrpc() {}

  public static final String SERVICE_NAME = "com.archforce.ath.rds.grpc.proto.HelloWorldService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.archforce.ath.rds.grpc.proto.Person,
      com.archforce.ath.rds.grpc.proto.Greeting> getSayHelloMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "sayHello",
      requestType = com.archforce.ath.rds.grpc.proto.Person.class,
      responseType = com.archforce.ath.rds.grpc.proto.Greeting.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.archforce.ath.rds.grpc.proto.Person,
      com.archforce.ath.rds.grpc.proto.Greeting> getSayHelloMethod() {
    io.grpc.MethodDescriptor<com.archforce.ath.rds.grpc.proto.Person, com.archforce.ath.rds.grpc.proto.Greeting> getSayHelloMethod;
    if ((getSayHelloMethod = HelloWorldServiceGrpc.getSayHelloMethod) == null) {
      synchronized (HelloWorldServiceGrpc.class) {
        if ((getSayHelloMethod = HelloWorldServiceGrpc.getSayHelloMethod) == null) {
          HelloWorldServiceGrpc.getSayHelloMethod = getSayHelloMethod = 
              io.grpc.MethodDescriptor.<com.archforce.ath.rds.grpc.proto.Person, com.archforce.ath.rds.grpc.proto.Greeting>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "com.archforce.ath.rds.grpc.proto.HelloWorldService", "sayHello"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.archforce.ath.rds.grpc.proto.Person.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.archforce.ath.rds.grpc.proto.Greeting.getDefaultInstance()))
                  .setSchemaDescriptor(new HelloWorldServiceMethodDescriptorSupplier("sayHello"))
                  .build();
          }
        }
     }
     return getSayHelloMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.archforce.ath.rds.grpc.proto.A1,
      com.archforce.ath.rds.grpc.proto.A2> getAddOperationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addOperation",
      requestType = com.archforce.ath.rds.grpc.proto.A1.class,
      responseType = com.archforce.ath.rds.grpc.proto.A2.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.archforce.ath.rds.grpc.proto.A1,
      com.archforce.ath.rds.grpc.proto.A2> getAddOperationMethod() {
    io.grpc.MethodDescriptor<com.archforce.ath.rds.grpc.proto.A1, com.archforce.ath.rds.grpc.proto.A2> getAddOperationMethod;
    if ((getAddOperationMethod = HelloWorldServiceGrpc.getAddOperationMethod) == null) {
      synchronized (HelloWorldServiceGrpc.class) {
        if ((getAddOperationMethod = HelloWorldServiceGrpc.getAddOperationMethod) == null) {
          HelloWorldServiceGrpc.getAddOperationMethod = getAddOperationMethod = 
              io.grpc.MethodDescriptor.<com.archforce.ath.rds.grpc.proto.A1, com.archforce.ath.rds.grpc.proto.A2>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "com.archforce.ath.rds.grpc.proto.HelloWorldService", "addOperation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.archforce.ath.rds.grpc.proto.A1.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.archforce.ath.rds.grpc.proto.A2.getDefaultInstance()))
                  .setSchemaDescriptor(new HelloWorldServiceMethodDescriptorSupplier("addOperation"))
                  .build();
          }
        }
     }
     return getAddOperationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.archforce.ath.rds.grpc.proto.A3,
      com.archforce.ath.rds.grpc.proto.A2> getAddOperation1Method;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addOperation1",
      requestType = com.archforce.ath.rds.grpc.proto.A3.class,
      responseType = com.archforce.ath.rds.grpc.proto.A2.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.archforce.ath.rds.grpc.proto.A3,
      com.archforce.ath.rds.grpc.proto.A2> getAddOperation1Method() {
    io.grpc.MethodDescriptor<com.archforce.ath.rds.grpc.proto.A3, com.archforce.ath.rds.grpc.proto.A2> getAddOperation1Method;
    if ((getAddOperation1Method = HelloWorldServiceGrpc.getAddOperation1Method) == null) {
      synchronized (HelloWorldServiceGrpc.class) {
        if ((getAddOperation1Method = HelloWorldServiceGrpc.getAddOperation1Method) == null) {
          HelloWorldServiceGrpc.getAddOperation1Method = getAddOperation1Method = 
              io.grpc.MethodDescriptor.<com.archforce.ath.rds.grpc.proto.A3, com.archforce.ath.rds.grpc.proto.A2>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "com.archforce.ath.rds.grpc.proto.HelloWorldService", "addOperation1"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.archforce.ath.rds.grpc.proto.A3.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.archforce.ath.rds.grpc.proto.A2.getDefaultInstance()))
                  .setSchemaDescriptor(new HelloWorldServiceMethodDescriptorSupplier("addOperation1"))
                  .build();
          }
        }
     }
     return getAddOperation1Method;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static HelloWorldServiceStub newStub(io.grpc.Channel channel) {
    return new HelloWorldServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static HelloWorldServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new HelloWorldServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static HelloWorldServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new HelloWorldServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class HelloWorldServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void sayHello(com.archforce.ath.rds.grpc.proto.Person request,
        io.grpc.stub.StreamObserver<com.archforce.ath.rds.grpc.proto.Greeting> responseObserver) {
      asyncUnimplementedUnaryCall(getSayHelloMethod(), responseObserver);
    }

    /**
     */
    public void addOperation(com.archforce.ath.rds.grpc.proto.A1 request,
        io.grpc.stub.StreamObserver<com.archforce.ath.rds.grpc.proto.A2> responseObserver) {
      asyncUnimplementedUnaryCall(getAddOperationMethod(), responseObserver);
    }

    /**
     */
    public void addOperation1(com.archforce.ath.rds.grpc.proto.A3 request,
        io.grpc.stub.StreamObserver<com.archforce.ath.rds.grpc.proto.A2> responseObserver) {
      asyncUnimplementedUnaryCall(getAddOperation1Method(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSayHelloMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.archforce.ath.rds.grpc.proto.Person,
                com.archforce.ath.rds.grpc.proto.Greeting>(
                  this, METHODID_SAY_HELLO)))
          .addMethod(
            getAddOperationMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.archforce.ath.rds.grpc.proto.A1,
                com.archforce.ath.rds.grpc.proto.A2>(
                  this, METHODID_ADD_OPERATION)))
          .addMethod(
            getAddOperation1Method(),
            asyncUnaryCall(
              new MethodHandlers<
                com.archforce.ath.rds.grpc.proto.A3,
                com.archforce.ath.rds.grpc.proto.A2>(
                  this, METHODID_ADD_OPERATION1)))
          .build();
    }
  }

  /**
   */
  public static final class HelloWorldServiceStub extends io.grpc.stub.AbstractStub<HelloWorldServiceStub> {
    private HelloWorldServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HelloWorldServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HelloWorldServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HelloWorldServiceStub(channel, callOptions);
    }

    /**
     */
    public void sayHello(com.archforce.ath.rds.grpc.proto.Person request,
        io.grpc.stub.StreamObserver<com.archforce.ath.rds.grpc.proto.Greeting> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSayHelloMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addOperation(com.archforce.ath.rds.grpc.proto.A1 request,
        io.grpc.stub.StreamObserver<com.archforce.ath.rds.grpc.proto.A2> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddOperationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addOperation1(com.archforce.ath.rds.grpc.proto.A3 request,
        io.grpc.stub.StreamObserver<com.archforce.ath.rds.grpc.proto.A2> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddOperation1Method(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class HelloWorldServiceBlockingStub extends io.grpc.stub.AbstractStub<HelloWorldServiceBlockingStub> {
    private HelloWorldServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HelloWorldServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HelloWorldServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HelloWorldServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.archforce.ath.rds.grpc.proto.Greeting sayHello(com.archforce.ath.rds.grpc.proto.Person request) {
      return blockingUnaryCall(
          getChannel(), getSayHelloMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.archforce.ath.rds.grpc.proto.A2 addOperation(com.archforce.ath.rds.grpc.proto.A1 request) {
      return blockingUnaryCall(
          getChannel(), getAddOperationMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.archforce.ath.rds.grpc.proto.A2 addOperation1(com.archforce.ath.rds.grpc.proto.A3 request) {
      return blockingUnaryCall(
          getChannel(), getAddOperation1Method(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class HelloWorldServiceFutureStub extends io.grpc.stub.AbstractStub<HelloWorldServiceFutureStub> {
    private HelloWorldServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HelloWorldServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HelloWorldServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HelloWorldServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.archforce.ath.rds.grpc.proto.Greeting> sayHello(
        com.archforce.ath.rds.grpc.proto.Person request) {
      return futureUnaryCall(
          getChannel().newCall(getSayHelloMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.archforce.ath.rds.grpc.proto.A2> addOperation(
        com.archforce.ath.rds.grpc.proto.A1 request) {
      return futureUnaryCall(
          getChannel().newCall(getAddOperationMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.archforce.ath.rds.grpc.proto.A2> addOperation1(
        com.archforce.ath.rds.grpc.proto.A3 request) {
      return futureUnaryCall(
          getChannel().newCall(getAddOperation1Method(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SAY_HELLO = 0;
  private static final int METHODID_ADD_OPERATION = 1;
  private static final int METHODID_ADD_OPERATION1 = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final HelloWorldServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(HelloWorldServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SAY_HELLO:
          serviceImpl.sayHello((com.archforce.ath.rds.grpc.proto.Person) request,
              (io.grpc.stub.StreamObserver<com.archforce.ath.rds.grpc.proto.Greeting>) responseObserver);
          break;
        case METHODID_ADD_OPERATION:
          serviceImpl.addOperation((com.archforce.ath.rds.grpc.proto.A1) request,
              (io.grpc.stub.StreamObserver<com.archforce.ath.rds.grpc.proto.A2>) responseObserver);
          break;
        case METHODID_ADD_OPERATION1:
          serviceImpl.addOperation1((com.archforce.ath.rds.grpc.proto.A3) request,
              (io.grpc.stub.StreamObserver<com.archforce.ath.rds.grpc.proto.A2>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class HelloWorldServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    HelloWorldServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.archforce.ath.rds.grpc.proto.HelloWorld.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("HelloWorldService");
    }
  }

  private static final class HelloWorldServiceFileDescriptorSupplier
      extends HelloWorldServiceBaseDescriptorSupplier {
    HelloWorldServiceFileDescriptorSupplier() {}
  }

  private static final class HelloWorldServiceMethodDescriptorSupplier
      extends HelloWorldServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    HelloWorldServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (HelloWorldServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new HelloWorldServiceFileDescriptorSupplier())
              .addMethod(getSayHelloMethod())
              .addMethod(getAddOperationMethod())
              .addMethod(getAddOperation1Method())
              .build();
        }
      }
    }
    return result;
  }
}
