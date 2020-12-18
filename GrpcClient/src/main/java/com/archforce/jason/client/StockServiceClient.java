package com.archforce.jason.client;

import com.archforce.ath.rds.grpc.proto.QueryStockInfoRequestParams;
import com.archforce.ath.rds.grpc.proto.QueryStockInfoResponse;
import com.archforce.ath.rds.grpc.proto.StockServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class StockServiceClient {

    private static final StockServiceGrpc.StockServiceBlockingStub stockServiceBlockingStub;

    static {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 6561).usePlaintext().build();
        stockServiceBlockingStub = StockServiceGrpc.newBlockingStub(managedChannel);
    }

    public String queryStockInfo() {
        QueryStockInfoRequestParams params = QueryStockInfoRequestParams.newBuilder().build();
        QueryStockInfoResponse response = stockServiceBlockingStub.queryStockInfo(params);
        return response.getResult();
    }

    @Test
    public void test1() {
        System.out.println(queryStockInfo());
    }
}
