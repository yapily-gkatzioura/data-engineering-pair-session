package com.yapily.pair.facts.servlet.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yapily.pair.facts.servlet.messaging.FactsSender;
import com.yapily.pair.facts.model.Fact;

@RestController
public class FactsController {

    @Autowired
    private FactsSender factsSender;

    @PostMapping("/fact")
    Fact newEmployee(@RequestBody Fact fact) {
        factsSender.send(fact);
        return fact;
    }

}
