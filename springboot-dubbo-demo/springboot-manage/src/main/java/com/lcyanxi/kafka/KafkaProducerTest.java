package com.lcyanxi.kafka;

import org.apache.kafka.clients.producer.*;

import java.util.Arrays;
import java.util.Properties;

/**
 * Created by lcyanxi on 2019/10/13
 */

public class KafkaProducerTest {

    public static void main(String[] args) {
        Properties props=new Properties();
        // 必须制定
        props.put("bootstrap.servers","lcyanxi01:9092");
        // 必须制定
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        // 必须制定
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        props.put ("acks","-1") ;
        props.put ("retries", 3) ;
        props.put ("batch.size", 323840) ;
        props.put ("linger.ms", 10) ;
        props.put ("buffer.memory", 33554432);
        props.put ("max.block.ms", 3000);

        Producer<String,String> producer= new KafkaProducer<>(props);
        for (int i=0;i<10;i++){
            ProducerRecord<String,String> record = new ProducerRecord<>("lcyanxi-topic", "key" + i + "发送成功", "value" + i + "发送成功");
            producer.send(record, (metadata, exception) -> {
                if (exception != null) {
                    System.err.println("发送消息失败：" + Arrays.toString(exception.getStackTrace()));
                }
                if (metadata != null) {
                    System.out.println("异步方式发送消息结果："
                            + "topic-" + metadata.topic()
                            + "|partition-" + metadata.partition()
                            + "|offset-" + metadata.offset());
                }
            });
        }
        producer.close();

    }
}
