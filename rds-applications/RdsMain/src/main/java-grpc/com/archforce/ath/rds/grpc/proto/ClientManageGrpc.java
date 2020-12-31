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
    comments = "Source: ClientManage.proto")
public final class ClientManageGrpc {

  private ClientManageGrpc() {}

  public static final String SERVICE_NAME = "com.archforce.ath.rds.grpc.proto.ClientManage";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.archforce.ath.rds.grpc.proto.ClientInfo,
      com.archforce.ath.rds.grpc.proto.Message> getLoginToServerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "loginToServer",
      requestType = com.archforce.ath.rds.grpc.proto.ClientInfo.class,
      responseType = com.archforce.ath.rds.grpc.proto.Message.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.archforce.ath.rds.grpc.proto.ClientInfo,
      com.archforce.ath.rds.grpc.proto.Message> getLoginToServerMethod() {
    io.grpc.MethodDescriptor<com.archforce.ath.rds.grpc.proto.ClientInfo, com.archforce.ath.rds.grpc.proto.Message> getLoginToServerMethod;
    if ((getLoginToServerMethod = ClientManageGrpc.getLoginToServerMethod) == null) {
      synchronized (ClientManageGrpc.class) {
        if ((getLoginToServerMethod = ClientManageGrpc.getLoginToServerMethod) == null) {
          ClientManageGrpc.getLoginToServerMethod = getLoginToServerMethod = 
              io.grpc.MethodDescriptor.<com.archforce.ath.rds.grpc.proto.ClientInfo, com.archforce.ath.rds.grpc.proto.Message>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "com.archforce.ath.rds.grpc.proto.ClientManage", "loginToServer"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.archforce.ath.rds.grpc.proto.ClientInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.archforce.ath.rds.grpc.proto.Message.getDefaultInstance()))
                  .setSchemaDescriptor(new ClientManageMethodDescriptorSupplier("loginToServer"))
                  .build();
          }
        }
     }
     return getLoginToServerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.archforce.ath.rds.grpc.proto.ClientInfo,
      com.archforce.ath.rds.grpc.proto.Message> getLogoutFromServerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "logoutFromServer",
      requestType = com.archforce.ath.rds.grpc.proto.ClientInfo.class,
      responseType = com.archforce.ath.rds.grpc.proto.Message.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.archforce.ath.rds.grpc.proto.ClientInfo,
      com.archforce.ath.rds.grpc.proto.Message> getLogoutFromServerMethod() {
    io.grpc.MethodDescriptor<com.archforce.ath.rds.grpc.proto.ClientInfo, com.archforce.ath.rds.grpc.proto.Message> getLogoutFromServerMethod;
    if ((getLogoutFromServerMethod = ClientManageGrpc.getLogoutFromServerMethod) == null) {
      synchronized (ClientManageGrpc.class) {
        if ((getLogoutFromServerMethod = ClientManageGrpc.getLogoutFromServerMethod) == null) {
          ClientManageGrpc.getLogoutFromServerMethod = getLogoutFromServerMethod = 
              io.grpc.MethodDescriptor.<com.archforce.ath.rds.grpc.proto.ClientInfo, com.archforce.ath.rds.grpc.proto.Message>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "com.archforce.ath.rds.grpc.proto.ClientManage", "logoutFromServer"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.archforce.ath.rds.grpc.proto.ClientInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.archforce.ath.rds.grpc.proto.Message.getDefaultInstance()))
                  .setSchemaDescriptor(new ClientManageMethodDescriptorSupplier("logoutFromServer"))
                  .build();
          }
        }
     }
     return getLogoutFromServerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.archforce.ath.rds.grpc.proto.ClientInfo,
      com.archforce.ath.rds.grpc.proto.Message> getSendMsgMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "sendMsg",
      requestType = com.archforce.ath.rds.grpc.proto.ClientInfo.class,
      responseType = com.archforce.ath.rds.grpc.proto.Message.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.archforce.ath.rds.grpc.proto.ClientInfo,
      com.archforce.ath.rds.grpc.proto.Message> getSendMsgMethod() {
    io.grpc.MethodDescriptor<com.archforce.ath.rds.grpc.proto.ClientInfo, com.archforce.ath.rds.grpc.proto.Message> getSendMsgMethod;
    if ((getSendMsgMethod = ClientManageGrpc.getSendMsgMethod) == null) {
      synchronized (ClientManageGrpc.class) {
        if ((getSendMsgMethod = ClientManageGrpc.getSendMsgMethod) == null) {
          ClientManageGrpc.getSendMsgMethod = getSendMsgMethod = 
              io.grpc.MethodDescriptor.<com.archforce.ath.rds.grpc.proto.ClientInfo, com.archforce.ath.rds.grpc.proto.Message>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "com.archforce.ath.rds.grpc.proto.ClientManage", "sendMsg"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.archforce.ath.rds.grpc.proto.ClientInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.archforce.ath.rds.grpc.proto.Message.getDefaultInstance()))
                  .setSchemaDescriptor(new ClientManageMethodDescriptorSupplier("sendMsg"))
                  .build();
          }
        }
     }
     return getSendMsgMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ClientManageStub newStub(io.grpc.Channel channel) {
    return new ClientManageStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ClientManageBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ClientManageBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ClientManageFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ClientManageFutureStub(channel);
  }

  /**
   */
  public static abstract class ClientManageImplBase implements io.grpc.BindableService {

    /**
     */
    public void loginToServer(com.archforce.ath.rds.grpc.proto.ClientInfo request,
        io.grpc.stub.StreamObserver<com.archforce.ath.rds.grpc.proto.Message> responseObserver) {
      asyncUnimplementedUnaryCall(getLoginToServerMethod(), responseObserver);
    }

    /**
     */
    public void logoutFromServer(com.archforce.ath.rds.grpc.proto.ClientInfo request,
        io.grpc.stub.StreamObserver<com.archforce.ath.rds.grpc.proto.Message> responseObserver) {
      asyncUnimplementedUnaryCall(getLogoutFromServerMethod(), responseObserver);
    }

    /**
     */
    public void sendMsg(com.archforce.ath.rds.grpc.proto.ClientInfo request,
        io.grpc.stub.StreamObserver<com.archforce.ath.rds.grpc.proto.Message> responseObserver) {
      asyncUnimplementedUnaryCall(getSendMsgMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getLoginToServerMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.archforce.ath.rds.grpc.proto.ClientInfo,
                com.archforce.ath.rds.grpc.proto.Message>(
                  this, METHODID_LOGIN_TO_SERVER)))
          .addMethod(
            getLogoutFromServerMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.archforce.ath.rds.grpc.proto.ClientInfo,
                com.archforce.ath.rds.grpc.proto.Message>(
                  this, METHODID_LOGOUT_FROM_SERVER)))
          .addMethod(
            getSendMsgMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.archforce.ath.rds.grpc.proto.ClientInfo,
                com.archforce.ath.rds.grpc.proto.Message>(
                  this, METHODID_SEND_MSG)))
          .build();
    }
  }

  /**
   */
  public static final class ClientManageStub extends io.grpc.stub.AbstractStub<ClientManageStub> {
    private ClientManageStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ClientManageStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClientManageStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ClientManageStub(channel, callOptions);
    }

    /**
     */
    public void loginToServer(com.archforce.ath.rds.grpc.proto.ClientInfo request,
        io.grpc.stub.StreamObserver<com.archforce.ath.rds.grpc.proto.Message> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLoginToServerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void logoutFromServer(com.archforce.ath.rds.grpc.proto.ClientInfo request,
        io.grpc.stub.StreamObserver<com.archforce.ath.rds.grpc.proto.Message> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLogoutFromServerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sendMsg(com.archforce.ath.rds.grpc.proto.ClientInfo request,
        io.grpc.stub.StreamObserver<com.archforce.ath.rds.grpc.proto.Message> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getSendMsgMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ClientManageBlockingStub extends io.grpc.stub.AbstractStub<ClientManageBlockingStub> {
    private ClientManageBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ClientManageBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClientManageBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ClientManageBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.archforce.ath.rds.grpc.proto.Message loginToServer(com.archforce.ath.rds.grpc.proto.ClientInfo request) {
      return blockingUnaryCall(
          getChannel(), getLoginToServerMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.archforce.ath.rds.grpc.proto.Message logoutFromServer(com.archforce.ath.rds.grpc.proto.ClientInfo request) {
      return blockingUnaryCall(
          getChannel(), getLogoutFromServerMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.archforce.ath.rds.grpc.proto.Message> sendMsg(
        com.archforce.ath.rds.grpc.proto.ClientInfo request) {
      return blockingServerStreamingCall(
          getChannel(), getSendMsgMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ClientManageFutureStub extends io.grpc.stub.AbstractStub<ClientManageFutureStub> {
    private ClientManageFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ClientManageFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClientManageFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ClientManageFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.archforce.ath.rds.grpc.proto.Message> loginToServer(
        com.archforce.ath.rds.grpc.proto.ClientInfo request) {
      return futureUnaryCall(
          getChannel().newCall(getLoginToServerMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.archforce.ath.rds.grpc.proto.Message> logoutFromServer(
        com.archforce.ath.rds.grpc.proto.ClientInfo request) {
      return futureUnaryCall(
          getChannel().newCall(getLogoutFromServerMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LOGIN_TO_SERVER = 0;
  private static final int METHODID_LOGOUT_FROM_SERVER = 1;
  private static final int METHODID_SEND_MSG = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ClientManageImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ClientManageImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LOGIN_TO_SERVER:
          serviceImpl.loginToServer((com.archforce.ath.rds.grpc.proto.ClientInfo) request,
              (io.grpc.stub.StreamObserver<com.archforce.ath.rds.grpc.proto.Message>) responseObserver);
          break;
        case METHODID_LOGOUT_FROM_SERVER:
          serviceImpl.logoutFromServer((com.archforce.ath.rds.grpc.proto.ClientInfo) request,
              (io.grpc.stub.StreamObserver<com.archforce.ath.rds.grpc.proto.Message>) responseObserver);
          break;
        case METHODID_SEND_MSG:
          serviceImpl.sendMsg((com.archforce.ath.rds.grpc.proto.ClientInfo) request,
              (io.grpc.stub.StreamObserver<com.archforce.ath.rds.grpc.proto.Message>) responseObserver);
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

  private static abstract class ClientManageBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ClientManageBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.archforce.ath.rds.grpc.proto.ClientManageOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ClientManage");
    }
  }

  private static final class ClientManageFileDescriptorSupplier
      extends ClientManageBaseDescriptorSupplier {
    ClientManageFileDescriptorSupplier() {}
  }

  private static final class ClientManageMethodDescriptorSupplier
      extends ClientManageBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ClientManageMethodDescriptorSupplier(String methodName) {
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
      synchronized (ClientManageGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ClientManageFileDescriptorSupplier())
              .addMethod(getLoginToServerMethod())
              .addMethod(getLogoutFromServerMethod())
              .addMethod(getSendMsgMethod())
              .build();
        }
      }
    }
    return result;
  }
}
