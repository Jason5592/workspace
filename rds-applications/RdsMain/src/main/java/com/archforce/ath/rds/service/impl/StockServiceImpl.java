package com.archforce.ath.rds.service.impl;

import com.alibaba.fastjson.JSON;
import com.archforce.ath.rds.grpc.proto.*;
import com.archforce.ath.rds.model.vo.StockInfoResponse;
import com.archforce.ath.rds.service.StockService;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@GrpcService
@Service
@Slf4j
public class StockServiceImpl extends StockServiceGrpc.StockServiceImplBase implements StockService {

    @Override
    public void queryStockInfo(QueryStockInfoRequestParams request, StreamObserver<QueryStockInfoResponse> responseObserver) {
        CommonParams commonParams = CommonParams.newBuilder()
                .setCustId("123456")
                .setFundAccountId("1234567")
                .setAccountId("1234567")
                .setClientSeqId(1)
                .build();

        StockInfo stockInfo = StockInfo.newBuilder()
                .setSecurityId("1011")
                .setSecuritySymbol("东方证券")
                .setMarket("101")
                .setAccountId("1234567")
                .setInitQty(10)
                .setLeftQty(100)
                .setAvailableQty(50)
                .setProfitLoss(1)
                .setMarketValue(1000)
                .setCostPrice(8)
                .setInitCrdSellBuyShareQty(16)
                .setInitCrdSellOccupiedAmt(20)
                .setCurCrdSellOccupiedQty(12)
                .setCurCrdSellOccupiedAmt(15)
                .build();

        QueryStockInfoResponseParams params = QueryStockInfoResponseParams.newBuilder()
                .setMessageType(MessageType.ORDER_MESSAGE)
                .setCommonParams(commonParams)
                .setQueryResultCode(1)
                .setUserInfo("Jason")
                .setLastIndex(1)
                .setTotalNum(5)
                .addStockInfo(stockInfo)
                .addStockInfo(stockInfo)
                .build();

        StockInfoResponse stockInfoResponse = new StockInfoResponse();
        QueryStockInfoResponse response = QueryStockInfoResponse.newBuilder().setResult(JSON.toJSONString(stockInfoResponse)).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
