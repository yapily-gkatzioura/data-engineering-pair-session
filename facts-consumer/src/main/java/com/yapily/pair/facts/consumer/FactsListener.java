package com.yapily.pair.facts.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.yapily.pair.facts.consumer.repository.FactRepository;
import com.yapily.pair.facts.model.Fact;

@Component
public class FactsListener {

    @Autowired
    private FactRepository factRepository;

    @KafkaListener(topics = "facts-topic")
    public void processMessage(Fact fact) {
        factRepository.save(fact);
    }

}
