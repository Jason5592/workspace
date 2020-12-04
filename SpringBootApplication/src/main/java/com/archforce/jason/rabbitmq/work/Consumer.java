package com.archforce.jason.rabbitmq.work;

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
            channel.queueDeclare(QUEUE_WORK, false, false, false, null);
        } catch (Exception e) {
            log.error(RABBITMQ_LOG_PREFIX + "queue declare failed", e);
            return;
        }
        try {
            channel.basicConsume(QUEUE_WORK, false, new Receiver(channel));
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
            channel.queueDeclare(QUEUE_WORK, false, false, false, null);
            // 处理完一个取一个，相当于有个负载均衡的作用，消费能力强的消费者消费的多一些
            channel.basicQos(1);
        } catch (Exception e) {
            log.error(RABBITMQ_LOG_PREFIX + "queue declare failed", e);
            return;
        }
        try {
            channel.basicConsume(QUEUE_WORK, false, new Receiver(channel));
        } catch (Exception e) {
            log.error(RABBITMQ_LOG_PREFIX + "basic consume failed", e);
        }

        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
        }
    }
}
