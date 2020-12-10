package com.archforce.jason.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.ProducerListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaMessageService implements ProducerListener<String, Object> {

    @Autowired
    public KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMessage(String topic, Object msg) {
        kafkaTemplate.setProducerListener(this);
        kafkaTemplate.send(topic, msg);
    }

    @Override
    public void onSuccess(ProducerRecord<String, Object> producerRecord, RecordMetadata recordMetadata) {
        log.info("消息[" + producerRecord.value() + "]发送成功！");
    }

    @Override
    public void onError(ProducerRecord<String, Object> producerRecord, Exception exception) {
        log.info("消息[" + producerRecord.value() + "]发送失败！");
    }
}
