package com.archforce.jason.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.junit.Test;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

@Slf4j
public class ConsumerTest {

    @Test
    public void test() {
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.0.60:9092");
        // 消费分组名
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "testGroup");
        // 是否自动提交offset
        /*
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
        自动提交offset的间隔时间
        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG , "1000");
        */
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");
        /*
        心跳时间，服务端broker通过心跳确认consumer是否故障，如果发现故障，就会通过心跳下发
        rebalance的指令给其他的consumer通知他们进行rebalance操作，这个时间可以稍微短一点
        */
        props.put(ConsumerConfig.HEARTBEAT_INTERVAL_MS_CONFIG, 1000);
        // 服务端broker多久感知不到一个consumer心跳就认为他故障了，默认是10秒
        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, 10 * 1000);
        /*
        如果两次poll操作间隔超过了这个时间，broker就会认为这个consumer处理能力太弱，
        会将其踢出消费组，将分区分配给别的consumer消费
        */
        props.put(ConsumerConfig.MAX_POLL_INTERVAL_MS_CONFIG, 30 * 1000);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());

        Consumer<String, String> consumer = new KafkaConsumer<>(props);
        String topic = "order";
        // consumer.subscribe(Collections.singletonList(topic));
        // 消费指定分区
        // consumer.assign(Collections.singletonList(new TopicPartition(topic, 0)));

        // 消息回溯消费
        consumer.assign(Collections.singletonList(new TopicPartition(topic, 0)));
        consumer.seekToBeginning(Collections.singletonList(new TopicPartition(topic, 0)));

        // 指定offset消费
        // consumer.seek(new TopicPartition(topic, 0), 10);
        while (true) {
            /*
            poll()是拉取消息的长轮询，主要是判断consumer是否还活着，只要我们持续调用poll()，
            消费者就会存活在自己所在的消费组中，并且持续消费指定的partition的消息
            底层做法：消费者向server持续发送心跳，如果一个时间段consumer挂掉或者不能发送心跳，这个消费者会被认为是挂掉了，
            这个partition也会被重新分配给其他consumer
             */
            ConsumerRecords<String, String> consumerRecords = consumer.poll(Duration.ofDays(Integer.MAX_VALUE));
            for (ConsumerRecord<String, String> record : consumerRecords) {
                log.info(String.format("收到消息：offset = %d, key = %s, value = %s%n", record.offset(), record.key(),
                        record.value()));
            }
            if (consumerRecords.count() > 0) {
                // 提交offset
                consumer.commitSync();
            }
        }
    }
}
