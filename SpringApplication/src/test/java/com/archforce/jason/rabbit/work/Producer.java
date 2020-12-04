package com.archforce.jason.rabbit.work;

import com.archforce.jason.rabbit.ApplicationTest;
import org.junit.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import static com.archforce.jason.ApplicationConstant.QUEUE_WORK;

public class Producer extends ApplicationTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void test() {
        for (int i = 0; i < 300; i++) {
            String message = "hello" + i;
            rabbitTemplate.convertAndSend(QUEUE_WORK, message);
        }
    }
}
