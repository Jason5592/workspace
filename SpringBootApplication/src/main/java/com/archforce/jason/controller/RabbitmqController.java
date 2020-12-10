package com.archforce.jason.controller;

import com.archforce.jason.rabbitmq.RabbitmqMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.archforce.jason.ApplicationConstant.EXCHANGE_FANOUT;

@RestController
@RequestMapping("/rabbitmq")
@Slf4j
public class RabbitmqController {

    @Autowired
    private RabbitmqMessageService messageService;

    @RequestMapping("/send")
    public String send() {
        for (int i = 0; i < 1; i++) {
            String message = "hello" + i;
            messageService.sendMessage(EXCHANGE_FANOUT, "", message);
        }
        return "消息发送成功！";
    }
}
