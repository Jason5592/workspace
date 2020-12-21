package com.archforce.ath.rds;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@Configuration
@EnableTransactionManagement
@EnableScheduling
@Slf4j
public class MainApplication {

    public static void main(String[] args) {
        log.info("**********************************************************************");
        log.info(ServerConstants.LOGGER_PREFIX + "启动服务...");
        SpringApplication.run(MainApplication.class, args);
        log.info(ServerConstants.LOGGER_PREFIX + "启动服务完成。");
        log.info("**********************************************************************");
    }
}