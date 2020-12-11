package com.archforce.jason;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@SpringBootApplication
@Configuration
@Slf4j
public class MainApplication {

    public static void main(String[] args) {
        log.info("项目启动中...");
        SpringApplication.run(MainApplication.class, args);
        log.info("项目启动成功！");

        Properties properties = System.getProperties();
        System.out.println(properties.getProperty("test"));
    }
}
