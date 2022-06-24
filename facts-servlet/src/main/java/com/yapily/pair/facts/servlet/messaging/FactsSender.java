package com.yapily.pair.facts.servlet.messaging;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.yapily.pair.facts.model.Fact;

@Component
public class FactsSender {

    private final String topic;
    private final KafkaTemplate<String, Fact> kafkaTemplate;

    public FactsSender(@Value("${facts.topic}") String topic, KafkaTemplate<String, Fact> kafkaTemplate) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(Fact fact) {
        kafkaTemplate.send(topic, fact);
    }

}
