package com.archforce.ath.rds.grpc.push;

import com.archforce.ath.rds.grpc.proto.ClientInfo;
import com.archforce.ath.rds.grpc.proto.ClientManageGrpc;
import com.archforce.ath.rds.grpc.proto.Message;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by zh_w5 on 2020/12/30.
 */
@GrpcService
@Slf4j
public class ClientManage extends ClientManageGrpc.ClientManageImplBase {

  public static final Map<String, StreamObserver<Message>> cacheClients = new ConcurrentHashMap<>();

  @Override
  public void loginToServer(ClientInfo clientInfo, StreamObserver<Message> responseObserver) {
    String clientId = clientInfo.getClientId();
    String username = clientInfo.getUsername();
    String password = clientInfo.getPassword();
    // TODO verify client
    cacheClients.put(clientId, responseObserver);
    log.info("远程客户端[" + clientId + "]已连接, messageObserver[" + responseObserver + "].");
  }

  @Override
  public void logoutFromServer(ClientInfo clientInfo, StreamObserver<Message> responseObserver) {
    String clientId = clientInfo.getClientId();
    String username = clientInfo.getUsername();
    String password = clientInfo.getPassword();
    // TODO verify client
    cacheClients.remove(clientId);
    log.info("远程客户端[" + clientId + "]已连接, messageObserver[" + responseObserver + "].");
  }

  @Override
  public void sendMsg(ClientInfo clientInfo, StreamObserver<Message> responseObserver) {
    String clientId = clientInfo.getClientId();
    String username = clientInfo.getUsername();
    String password = clientInfo.getPassword();
    // TODO verify client
    cacheClients.put(clientId, responseObserver);
    log.info("远程客户端[" + clientId + "]已连接, messageObserver[" + responseObserver + "].");
  }
}
