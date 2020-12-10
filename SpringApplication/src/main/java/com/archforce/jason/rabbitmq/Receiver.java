package com.archforce.jason.rabbitmq;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

import static com.archforce.jason.ApplicationConstant.RABBITMQ_LOG_PREFIX;

@Slf4j
public class Receiver extends DefaultConsumer {

    private final Channel channel;

    public Receiver(Channel channel) {
        super(channel);
        this.channel = channel;
    }

    @Override
    public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
        log.info(RABBITMQ_LOG_PREFIX + "receive message[" + new String(body) + "].");
        // multiple=false表示只签收当前消息，true会签收所有未签收的消息
        channel.basicAck(envelope.getDeliveryTag(), false);
//        channel.basicNack(envelope.getDeliveryTag(), false, true);
    }
}
