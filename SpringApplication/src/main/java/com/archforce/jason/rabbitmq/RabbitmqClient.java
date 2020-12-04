package com.archforce.jason.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import static com.archforce.jason.ApplicationConstant.RABBITMQ_LOG_PREFIX;

@Slf4j
public class RabbitmqClient {

    private final static ConnectionFactory factory;

    //回调函数: confirm确认
    static final RabbitTemplate.ConfirmCallback confirmCallback = new RabbitTemplate.ConfirmCallback() {
        /**
         * CorrelationData 消息的附加信息，即自定义id
         * isack 代表消息是否被broker（MQ）接收 true 代表接收 false代表拒收。
         * cause 如果拒收cause则说明拒收的原因，帮助我们进行后续处理
         */
        @Override
        public void confirm(CorrelationData correlationData, boolean ack, String cause) {
            log.info("correlationData-----------" + correlationData);
            log.info("ack-----------" + ack);
            if (ack) {
                //更新数据库，可靠性投递机制
                log.info("confirm message....");
            } else {
                log.error(cause);
            }
        }
    };
    //回调函数: return返回
    static final RabbitTemplate.ReturnCallback returnCallback = new RabbitTemplate.ReturnCallback() {
        @Override
        public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
            log.info("return exchange: " + exchange + ", routingKey: "
                    + routingKey + ", replyCode: " + replyCode + ", replyText: " + replyText);

        }
    };

    static {
        factory = new ConnectionFactory();
        factory.setUsername("admin");
        factory.setPassword("admin");
        factory.setVirtualHost("jason");
        factory.setHost("192.168.162.128");
        factory.setPort(5672);
    }

    public static Channel getChannel() {
        Connection conn;
        try {
            conn = factory.newConnection();
        } catch (Exception e) {
            log.error(RABBITMQ_LOG_PREFIX + "new connection failed!", e);
            return null;
        }
        Channel channel;
        try {
            channel = conn.createChannel();
        } catch (Exception e) {
            log.error(RABBITMQ_LOG_PREFIX + "create channel failed!", e);
            return null;
        }
        return channel;
    }
}

