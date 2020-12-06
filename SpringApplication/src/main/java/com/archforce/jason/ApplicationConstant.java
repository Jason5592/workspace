package com.archforce.jason;

public interface ApplicationConstant {

    String RABBITMQ_LOG_PREFIX = "[rabbitmq]";
    String EXCHANGE_FANOUT = "exchange_fanout";
    String EXCHANGE_DIRECT = "exchange_direct";
    String EXCHANGE_TOPIC = "exchange_topic";
    String QUEUE_HELLO = "hello";
    String QUEUE_WORK= "work";
    String QUEUE_PUBSUB1 = "pubsub1";
    String QUEUE_PUBSUB2 = "pubsub2";
    String QUEUE_ROUTING1= "routing1";
    String QUEUE_ROUTING2= "routing2";
    String QUEUE_TOPIC1= "topic1";
    String QUEUE_TOPIC2= "topic2";
    String QUEUE_CLOSE_ORDER_TTL= "close_order_ttl";
}
