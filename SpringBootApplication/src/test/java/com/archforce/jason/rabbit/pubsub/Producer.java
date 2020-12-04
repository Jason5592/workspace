package com.archforce.jason.rabbit.pubsub;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.archforce.jason.ApplicationConstant.EXCHANGE_FANOUT;

@SpringBootTest
@RunWith(SpringRunner.class)
public class Producer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void test() {
        for (int i = 0; i < 300; i++) {
            String message = "hello" + i;
            rabbitTemplate.convertAndSend(EXCHANGE_FANOUT, "", message);
        }
    }
}
