package com.archforce.jason.rabbitmq.routing;

import com.archforce.jason.rabbitmq.RabbitmqClient;
import com.archforce.jason.rabbitmq.Receiver;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static com.archforce.jason.ApplicationConstant.*;

@Slf4j
public class Consumer {

    @Test
    public void test1() {
        Channel channel = RabbitmqClient.getChannel();
        if (channel == null) {
            log.warn(RABBITMQ_LOG_PREFIX + "get channel failed!");
            return;
        }
        try {
            channel.queueDeclare(QUEUE_ROUTING1, false, false, false, null);
            channel.queueBind(QUEUE_ROUTING1, EXCHANGE_DIRECT, "111");
        } catch (Exception e) {
            log.error(RABBITMQ_LOG_PREFIX + "queue bind failed", e);
            return;
        }
        try {
            channel.basicConsume(QUEUE_ROUTING1, false, new Receiver(channel));
        } catch (Exception e) {
            log.error(RABBITMQ_LOG_PREFIX + "basic consume failed", e);
        }

        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
        }
    }

    @Test
    public void test2() {
        Channel channel = RabbitmqClient.getChannel();
        if (channel == null) {
            log.warn(RABBITMQ_LOG_PREFIX + "get channel failed!");
            return;
        }
        try {
            channel.queueDeclare(QUEUE_ROUTING2, false, false, false, null);
            channel.queueBind(QUEUE_ROUTING2, EXCHANGE_DIRECT, "111");
        } catch (Exception e) {
            log.error(RABBITMQ_LOG_PREFIX + "queue bind failed", e);
            return;
        }
        try {
            channel.basicConsume(QUEUE_ROUTING2, false, new Receiver(channel));
        } catch (Exception e) {
            log.error(RABBITMQ_LOG_PREFIX + "basic consume failed", e);
        }

        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
        }
    }
}
