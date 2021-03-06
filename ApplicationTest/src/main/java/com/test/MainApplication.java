package com.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class MainApplication {

    public static void main(String[] args) {
        log.info("项目启动了");
        SpringApplication.run(MainApplication.class, args);
    }
}
