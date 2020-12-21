package com.archforce.jason.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ConsumerListener {

    @KafkaListener(topics = "test-topic", groupId = "test-group")
    public void listener(ConsumerRecord<String, Object> consumerRecord, Acknowledgment acknowledgment, Consumer<String, Object> consumer) {
        log.info("收到消息[" + consumerRecord.value() + "].");
//        acknowledgment.acknowledge();
        consumer.commitSync();
//        consumer.commitAsync(new OffsetCommitCallback() {
//            @Override
//            public void onComplete(Map<TopicPartition, OffsetAndMetadata> map, Exception e) {
//
//            }
//        });
    }
}
