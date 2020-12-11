package com.archforce.jason.controller;

import com.archforce.jason.kafka.KafkaMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
@Slf4j
public class KafkaController {

    @Autowired
    private KafkaMessageService messageService;

    @RequestMapping("/send")
    public String send() {
        messageService.sendMessage("test-topic", 0, "1", "hello");
        return "消息发送成功！";
    }
}
