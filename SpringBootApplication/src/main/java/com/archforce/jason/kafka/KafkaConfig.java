package com.archforce.jason.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.LoggingProducerListener;
import org.springframework.kafka.support.ProducerListener;

@Configuration
@Slf4j
public class KafkaConfig {

    @Bean
    public ProducerListener<Object, Object> producerListener() {
        return new LoggingProducerListener<>();
    }

    @Bean
    public NewTopic initialTopic() {
        NewTopic newTopic = new NewTopic("test-topic1", 3, (short) 3);
        log.info("主题[" + "test-topic1" + "]创建成功,分区数是[" + newTopic.numPartitions() + "], 副本数是[" + newTopic.replicationFactor() + "].");
        return newTopic;
    }
}
