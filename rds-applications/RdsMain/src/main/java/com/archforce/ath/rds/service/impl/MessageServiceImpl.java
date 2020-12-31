package com.archforce.ath.rds.service.impl;

import com.archforce.ath.rds.grpc.proto.Message;
import com.archforce.ath.rds.grpc.push.ClientManage;
import com.archforce.ath.rds.service.MessageService;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by zh_w5 on 2020/12/30.
 */
@Slf4j
@Service
public class MessageServiceImpl implements MessageService {

  private volatile static long i = 1;

  public static final Object obj = new Object();

  @Override
  public void send(String msg) {
    long msgId;
    synchronized (obj) {
      msgId = i++;
    }
    Message message = Message.newBuilder().setMsgId(msgId).setMessage(msg).build();
    Map<String, StreamObserver<Message>> streamObservers = ClientManage.cacheClients;
    for (String clientId : streamObservers.keySet()) {
      StreamObserver<Message> streamObserver = streamObservers.get(clientId);
      try {
        streamObserver.onNext(message);
      } catch (Exception e) {
        log.error("send message failed! ClientId[" + clientId + "]", e);
      }
    }
  }
}
