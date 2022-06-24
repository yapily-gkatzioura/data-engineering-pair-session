package com.yapily.pair.facts.consumer.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.yapily.pair.facts.model.Fact;

public interface FactRepository extends ElasticsearchRepository<Fact, String> {

}
