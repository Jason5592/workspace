package com.archforce.jason;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.LoggingProducerListener;
import org.springframework.kafka.support.ProducerListener;

@SpringBootApplication
@Configuration
@Slf4j
public class MainApplication {

    @Bean
    public ProducerListener<Object, Object> producerListener() {
        return new LoggingProducerListener<>();
    }

    public static void main(String[] args) {
        log.info("项目启动中...");
        SpringApplication.run(MainApplication.class, args);
        log.info("项目启动成功！");
    }
}
