package com.example.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.function.BiConsumer;

@Component
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public BiConsumer<String, String> produce() {
        return (topic, payload) -> {
            System.out.println("------ PRODUCER ------");
            System.out.println("topic: " + topic + " payload: " + payload);
            kafkaTemplate.send(topic, payload);
        };
    }

}
