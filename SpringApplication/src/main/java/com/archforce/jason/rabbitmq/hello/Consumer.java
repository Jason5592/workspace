package com.archforce.jason.rabbitmq.hello;

import com.archforce.jason.rabbitmq.RabbitmqClient;
import com.archforce.jason.rabbitmq.Receiver;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static com.archforce.jason.ApplicationConstant.QUEUE_HELLO;
import static com.archforce.jason.ApplicationConstant.RABBITMQ_LOG_PREFIX;

@Slf4j
public class Consumer {

    @Test
    public void test() {
        Channel channel = RabbitmqClient.getChannel();
        if (channel == null) {
            log.warn(RABBITMQ_LOG_PREFIX + "get channel failed!");
            return;
        }
        try {
            channel.queueDeclare(QUEUE_HELLO, false, false, false, null);
        } catch (Exception e) {
            log.error(RABBITMQ_LOG_PREFIX + "queue declare failed", e);
            return;
        }
        try {
            channel.basicConsume(QUEUE_HELLO, false, new Receiver(channel));
        } catch (Exception e) {
            log.error(RABBITMQ_LOG_PREFIX + "basic consume failed", e);
        }

        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
        }
    }
}
