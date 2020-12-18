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
 * <pre>
 * 股份持仓服务
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.16.1)",
    comments = "Source: StockService.proto")
public final class StockServiceGrpc {

  private StockServiceGrpc() {}

  public static final String SERVICE_NAME = "com.archforce.ath.rds.grpc.proto.StockService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.archforce.ath.rds.grpc.proto.QueryStockInfoRequestParams,
      com.archforce.ath.rds.grpc.proto.QueryStockInfoResponse> getQueryStockInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "queryStockInfo",
      requestType = com.archforce.ath.rds.grpc.proto.QueryStockInfoRequestParams.class,
      responseType = com.archforce.ath.rds.grpc.proto.QueryStockInfoResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.archforce.ath.rds.grpc.proto.QueryStockInfoRequestParams,
      com.archforce.ath.rds.grpc.proto.QueryStockInfoResponse> getQueryStockInfoMethod() {
    io.grpc.MethodDescriptor<com.archforce.ath.rds.grpc.proto.QueryStockInfoRequestParams, com.archforce.ath.rds.grpc.proto.QueryStockInfoResponse> getQueryStockInfoMethod;
    if ((getQueryStockInfoMethod = StockServiceGrpc.getQueryStockInfoMethod) == null) {
      synchronized (StockServiceGrpc.class) {
        if ((getQueryStockInfoMethod = StockServiceGrpc.getQueryStockInfoMethod) == null) {
          StockServiceGrpc.getQueryStockInfoMethod = getQueryStockInfoMethod = 
              io.grpc.MethodDescriptor.<com.archforce.ath.rds.grpc.proto.QueryStockInfoRequestParams, com.archforce.ath.rds.grpc.proto.QueryStockInfoResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "com.archforce.ath.rds.grpc.proto.StockService", "queryStockInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.archforce.ath.rds.grpc.proto.QueryStockInfoRequestParams.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.archforce.ath.rds.grpc.proto.QueryStockInfoResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StockServiceMethodDescriptorSupplier("queryStockInfo"))
                  .build();
          }
        }
     }
     return getQueryStockInfoMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static StockServiceStub newStub(io.grpc.Channel channel) {
    return new StockServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static StockServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new StockServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static StockServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new StockServiceFutureStub(channel);
  }

  /**
   * <pre>
   * 股份持仓服务
   * </pre>
   */
  public static abstract class StockServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * 查询股份持仓信息
     * </pre>
     */
    public void queryStockInfo(com.archforce.ath.rds.grpc.proto.QueryStockInfoRequestParams request,
        io.grpc.stub.StreamObserver<com.archforce.ath.rds.grpc.proto.QueryStockInfoResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getQueryStockInfoMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getQueryStockInfoMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.archforce.ath.rds.grpc.proto.QueryStockInfoRequestParams,
                com.archforce.ath.rds.grpc.proto.QueryStockInfoResponse>(
                  this, METHODID_QUERY_STOCK_INFO)))
          .build();
    }
  }

  /**
   * <pre>
   * 股份持仓服务
   * </pre>
   */
  public static final class StockServiceStub extends io.grpc.stub.AbstractStub<StockServiceStub> {
    private StockServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StockServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StockServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StockServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * 查询股份持仓信息
     * </pre>
     */
    public void queryStockInfo(com.archforce.ath.rds.grpc.proto.QueryStockInfoRequestParams request,
        io.grpc.stub.StreamObserver<com.archforce.ath.rds.grpc.proto.QueryStockInfoResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getQueryStockInfoMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * 股份持仓服务
   * </pre>
   */
  public static final class StockServiceBlockingStub extends io.grpc.stub.AbstractStub<StockServiceBlockingStub> {
    private StockServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StockServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StockServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StockServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * 查询股份持仓信息
     * </pre>
     */
    public com.archforce.ath.rds.grpc.proto.QueryStockInfoResponse queryStockInfo(com.archforce.ath.rds.grpc.proto.QueryStockInfoRequestParams request) {
      return blockingUnaryCall(
          getChannel(), getQueryStockInfoMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * 股份持仓服务
   * </pre>
   */
  public static final class StockServiceFutureStub extends io.grpc.stub.AbstractStub<StockServiceFutureStub> {
    private StockServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StockServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StockServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StockServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * 查询股份持仓信息
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.archforce.ath.rds.grpc.proto.QueryStockInfoResponse> queryStockInfo(
        com.archforce.ath.rds.grpc.proto.QueryStockInfoRequestParams request) {
      return futureUnaryCall(
          getChannel().newCall(getQueryStockInfoMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_QUERY_STOCK_INFO = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final StockServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(StockServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_QUERY_STOCK_INFO:
          serviceImpl.queryStockInfo((com.archforce.ath.rds.grpc.proto.QueryStockInfoRequestParams) request,
              (io.grpc.stub.StreamObserver<com.archforce.ath.rds.grpc.proto.QueryStockInfoResponse>) responseObserver);
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

  private static abstract class StockServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    StockServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.archforce.ath.rds.grpc.proto.StockServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("StockService");
    }
  }

  private static final class StockServiceFileDescriptorSupplier
      extends StockServiceBaseDescriptorSupplier {
    StockServiceFileDescriptorSupplier() {}
  }

  private static final class StockServiceMethodDescriptorSupplier
      extends StockServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    StockServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (StockServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new StockServiceFileDescriptorSupplier())
              .addMethod(getQueryStockInfoMethod())
              .build();
        }
      }
    }
    return result;
  }
}
