package com.lcyanxi.worker.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Collections;
import java.util.Properties;

/**
 * Created by lcyanxi on 2019/10/13
 */

public class KafkaConsumerTest {

    public static void main(String[] args) {
        String topicName="lcyanxi-topic";
        String groupID= "lcyanxi-group";

        Properties props = new Properties();
        // 必须指定
        props.put("bootstrap.servers","lcyanxi02:9092");
        // 必须指定 消费分组名
        props.put("group.id", groupID);
        // 是否自动提交offset
        props.put("enable.auto.commit", "false");
        // 自动提交offset的间隔时间
        props.put("auto.commit.interval.ms", "5000");
        // 从最早的消息开始读取
        props.put("auto.offset.reset","earliest");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        // 消费主题
        consumer.subscribe(Collections.singletonList(topicName));
        // 消费指定分区
        //consumer.assign(Arrays.asList(new TopicPartition("test", 0)));
        while (true) {
            /*
             * poll() API 主要是判断consumer是否还活着，只要我们持续调用poll()，
             *消费者就会存活在自己所在的group中，
             * 并且持续的消费指定partition的消息。底层是这么做的:
             *消费者向server持续发送心跳，如果一个时间段（session.timeout.ms）
             *consumer挂掉或是不能发送心跳，这个消费者会被认为是挂掉了，
             * 这个Partition也会被重新分配给其他consumer（rebalance）
             */
            ConsumerRecords<String, String> records = consumer.poll(5000);
            for (ConsumerRecord<String, String> record : records) {
                System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
                System.err.println("-------------------------------------------------");
            }
            //手动提交offset
            if (records.count() > 0) {
                // 提交offset
                consumer.commitSync();
            }

        }
    }

}