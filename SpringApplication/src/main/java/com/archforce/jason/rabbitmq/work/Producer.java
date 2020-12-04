package com.archforce.jason.rabbitmq.work;

import com.archforce.jason.rabbitmq.RabbitmqClient;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static com.archforce.jason.ApplicationConstant.QUEUE_WORK;
import static com.archforce.jason.ApplicationConstant.RABBITMQ_LOG_PREFIX;

@Slf4j
public class Producer {

    @Test
    public void test() {
        Channel channel = RabbitmqClient.getChannel();
        if (channel == null) {
            log.warn(RABBITMQ_LOG_PREFIX + "get channel failed!");
            return;
        }
        try {
            channel.queueDeclare(QUEUE_WORK, false, false, false, null);
        } catch (Exception e) {
            log.error(RABBITMQ_LOG_PREFIX + "queue declare failed", e);
            return;
        }

        try {
            for (int i = 0; i < 300; i++) {
                String message = "hello" + i;
                channel.basicPublish("", QUEUE_WORK, null, message.toString().getBytes());
                log.info(RABBITMQ_LOG_PREFIX + "basic publish success! Message[" + message + "].");
            }
        } catch (Exception e) {
            log.error(RABBITMQ_LOG_PREFIX + "basic publish failed", e);
        }
    }
}
