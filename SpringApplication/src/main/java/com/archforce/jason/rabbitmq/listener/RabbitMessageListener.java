package com.archforce.jason.rabbitmq.listener;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;

import static com.archforce.jason.ApplicationConstant.RABBITMQ_LOG_PREFIX;

@Slf4j
public class RabbitMessageListener implements ChannelAwareMessageListener {

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        log.info(RABBITMQ_LOG_PREFIX + "receive message[" + message + "].");
        // 手动签收
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        // 手动拒收
//        channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
    }
}
