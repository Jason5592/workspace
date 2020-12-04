package com.archforce.jason;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Slf4j
public class MainApplication {

    public static void main(String[] args) {
        log.info("项目启动中...");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-rabbitmq-consumer.xml");
        log.info("项目启动成功！");
    }
}
