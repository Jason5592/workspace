package com.archforce.ath.rds;


import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.serverfactory.GrpcServerConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.concurrent.TimeUnit;

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