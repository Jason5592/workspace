package com.archforce.jason.rabbitmq.hello;

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
            // durable 是否持久化
            // exclusive 是否私有
            // autoDelete 是否自动删除
            // arguments 额外参数
            channel.queueDeclare(QUEUE_HELLO, false, false, false, null);
        } catch (Exception e) {
            log.error(RABBITMQ_LOG_PREFIX + "queue declare failed", e);
            return;
        }
        String message = "hello";
        try {
            channel.basicPublish("", QUEUE_HELLO, null, message.getBytes());
            log.info(RABBITMQ_LOG_PREFIX + "basic publish success! Message[" + message + "].");
        } catch (Exception e) {
            log.error(RABBITMQ_LOG_PREFIX + "basic publish failed", e);
        }
    }
}
