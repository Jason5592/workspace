package com.archforce.jason.rabbitmq.pubsub;

import com.archforce.jason.rabbitmq.RabbitmqClient;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static com.archforce.jason.ApplicationConstant.*;

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
            for (int i = 0; i < 300; i++) {
                String message = "hello" + i;
                channel.basicPublish(EXCHANGE_FANOUT, "", null, message.toString().getBytes());
                log.info(RABBITMQ_LOG_PREFIX + "basic publish success! Message[" + message + "].");
            }
        } catch (Exception e) {
            log.error(RABBITMQ_LOG_PREFIX + "basic publish failed", e);
        }
    }
}
