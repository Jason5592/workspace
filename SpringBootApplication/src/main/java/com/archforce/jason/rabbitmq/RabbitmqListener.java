package com.archforce.jason.rabbitmq;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static com.archforce.jason.ApplicationConstant.QUEUE_PUBSUB1;
import static com.archforce.jason.ApplicationConstant.QUEUE_PUBSUB2;

@Component
@Slf4j
public class RabbitmqListener {

    //定义方法进行信息的监听   RabbitListener中的参数用于表示监听的是哪一个队列
    @RabbitListener(queues = QUEUE_PUBSUB1, ackMode = "MANUAL")
    public void listener1(Message message, Channel channel) {
        log.info("QUEUE_PUBSUB1收到消息[" + new String(message.getBody()) + "].");
        try {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception e) {

        }
    }

    //定义方法进行信息的监听   RabbitListener中的参数用于表示监听的是哪一个队列
    @RabbitListener(queues = QUEUE_PUBSUB2, ackMode = "MANUAL")
    public void listener2(Message message, Channel channel) {
        log.info("QUEUE_PUBSUB2收到消息[" + new String(message.getBody()) + "].");
        try {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception e) {

        }
    }
}
