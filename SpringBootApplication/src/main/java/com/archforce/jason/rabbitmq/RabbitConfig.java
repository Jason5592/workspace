package com.archforce.jason.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.archforce.jason.ApplicationConstant.EXCHANGE_FANOUT;
import static com.archforce.jason.ApplicationConstant.QUEUE_PUBSUB1;

@Configuration
public class RabbitConfig {

    @Bean("pubsubQueue1")
    public Queue pubsubQueue1() {
        return QueueBuilder.durable(QUEUE_PUBSUB1).build();
    }

    @Bean("pubsubQueue2")
    public Queue pubsubQueue2() {
        return QueueBuilder.durable(QUEUE_PUBSUB1).build();
    }

    @Bean("fanoutExchange")
    public Exchange fanoutExchange() {
        // 默认持久化durable=true
        return ExchangeBuilder.fanoutExchange(EXCHANGE_FANOUT).build();
    }

    @Bean
    public Binding bindingPubsubQueue1(@Qualifier("pubsubQueue1") Queue queue, @Qualifier("fanoutExchange") Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("").noargs();
    }

    @Bean
    public Binding bindingPubsubQueue2(@Qualifier("pubsubQueue2") Queue queue, @Qualifier("fanoutExchange") Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("").noargs();
    }
}
