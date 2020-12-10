package com.archforce.jason.rabbitmq.hello;

import com.archforce.jason.rabbitmq.RabbitmqClient;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmListener;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static com.archforce.jason.ApplicationConstant.QUEUE_HELLO;
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
            channel.confirmSelect();
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

        try {
            // 普通confirm模式
            if (channel.waitForConfirms()) {
                log.info("消息发送成功" );
            }
        } catch (Exception e) {
        }

        try {
            // 批量confirm模式，直到所有信息都发布，只要有一个未确认就会IOException
            channel.waitForConfirmsOrDie();
        } catch (Exception e) {
        }

        // 异步监听确认和未确认的消息
        channel.addConfirmListener(new ConfirmListener() {
            @Override
            public void handleNack(long deliveryTag, boolean multiple) {
                log.info("未确认消息，标识：" + deliveryTag);
            }

            @Override
            public void handleAck(long deliveryTag, boolean multiple) {
                log.info(String.format("已确认消息，标识：%d，多个消息：%b", deliveryTag, multiple));
            }
        });
    }
}
