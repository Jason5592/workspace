package com.archforce.jason.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;

import static com.archforce.jason.ApplicationConstant.RABBITMQ_LOG_PREFIX;

@Slf4j
public class RabbitmqClient {

    private final static ConnectionFactory factory;

    static {
        factory = new ConnectionFactory();
        factory.setUsername("admin");
        factory.setPassword("admin");
        factory.setVirtualHost("jason");
        factory.setHost("192.168.162.128");
        factory.setPort(5672);
    }

    public static Channel getChannel() {
        Connection conn;
        try {
            conn = factory.newConnection();
        } catch (Exception e) {
            log.error(RABBITMQ_LOG_PREFIX + "new connection failed!", e);
            return null;
        }
        Channel channel;
        try {
            channel = conn.createChannel();
        } catch (Exception e) {
            log.error(RABBITMQ_LOG_PREFIX + "create channel failed!", e);
            return null;
        }
        return channel;
    }
}

