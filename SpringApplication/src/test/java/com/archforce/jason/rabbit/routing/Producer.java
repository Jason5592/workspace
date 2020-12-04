package com.archforce.jason.rabbit.routing;

import com.archforce.jason.rabbit.ApplicationTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import static com.archforce.jason.ApplicationConstant.EXCHANGE_DIRECT;

@Slf4j
public class Producer extends ApplicationTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void test() {
        for (int i = 0; i < 300; i++) {
            String message = "hello" + i;
            rabbitTemplate.convertAndSend(EXCHANGE_DIRECT, "hello", message);
            log.info("send message success! Message[" + message + "].");
        }
    }
}
