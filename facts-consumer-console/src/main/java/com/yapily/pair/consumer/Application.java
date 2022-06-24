package com.yapily.pair.consumer;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import com.yapily.pair.Fact;

public class Application {

    public static void main(String[] args) {
        String topic = args[0];

        var kafkaProperties = new Properties();
        kafkaProperties.put("bootstrap.servers", "localhost:9092");
        kafkaProperties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        kafkaProperties.put("value.deserializer",  "org.springframework.kafka.support.serializer.JsonDeserializer");
        kafkaProperties.put("spring.json.trusted.packages","*");
        kafkaProperties.put(ConsumerConfig.GROUP_ID_CONFIG, "console-consumer");

        Consumer<String, Fact> consumer = new KafkaConsumer<>(kafkaProperties);
        consumer.subscribe(Arrays.asList(topic));

        while (true) {
            ConsumerRecords<String, Fact> records = consumer.poll(Duration.ofSeconds(5));
            consumer.commitSync();
        }

    }

}
