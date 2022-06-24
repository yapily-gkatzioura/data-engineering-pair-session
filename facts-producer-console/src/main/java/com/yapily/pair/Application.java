package com.yapily.pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class Application {

    public static void main(String[] args) throws IOException {
        String author = args[0];
        String topic = args[1];

        var kafkaProperties = new Properties();
        kafkaProperties.put("bootstrap.servers", "localhost:9092");
        kafkaProperties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        kafkaProperties.put("value.serializer",  "org.springframework.kafka.support.serializer.JsonSerializer");

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        Producer<String, Fact> producer = new KafkaProducer<>(kafkaProperties);

        while (true) {
            String content = reader.readLine();
            Fact fact = new Fact();
            fact.setAuthor(author);
            fact.setContent(content);

            producer.send(new ProducerRecord<>(topic, fact));
        }

    }

}
