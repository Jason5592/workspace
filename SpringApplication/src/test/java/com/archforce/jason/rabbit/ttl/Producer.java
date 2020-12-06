package com.archforce.jason.rabbit.ttl;

import com.archforce.jason.rabbit.ApplicationTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import static com.archforce.jason.ApplicationConstant.QUEUE_CLOSE_ORDER_TTL;

@Slf4j
public class Producer extends ApplicationTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void test() {
        for (int i = 0; i < 300; i++) {
            String message = "hello" + i;
            rabbitTemplate.convertAndSend(QUEUE_CLOSE_ORDER_TTL, message);
            log.info("send message success! Message[" + message + "].");
        }
    }
}
