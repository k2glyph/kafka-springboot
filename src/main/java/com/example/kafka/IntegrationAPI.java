package com.example.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class IntegrationAPI {

    @Autowired
    private KafkaProducer kafkaProducer;

    @GetMapping("/kafka/{topic}/{message}")
    public void sendMessage(@PathVariable String topic, @PathVariable String message) {
        kafkaProducer.produce().accept(topic, message);
    }
}
