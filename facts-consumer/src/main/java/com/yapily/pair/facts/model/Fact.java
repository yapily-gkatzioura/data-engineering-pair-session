package com.yapily.pair.facts.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.Data;

@Data
@Document(indexName = "fact")
public class Fact {

    @Id
    private String id;

    private String author;
    private String content;

}
