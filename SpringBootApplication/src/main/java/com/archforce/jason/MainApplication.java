package com.archforce.jason;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@Configuration
@Slf4j
public class MainApplication {

    private ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        log.info("项目启动中...");
        SpringApplication.run(MainApplication.class, args);
        log.info("项目启动成功！");

        Properties properties = System.getProperties();
        System.out.println(properties.getProperty("test"));

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                5, 10, 3000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(5), new ThreadPoolExecutor.CallerRunsPolicy()
        );
        threadPoolExecutor.submit(new Runnable() {
            @Override
            public void run() {

            }
        });
    }
}
