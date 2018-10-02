package com.example.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class KafkaConsumer {

    @KafkaListener(topics = "topic1", groupId = "test-consumer-group")
    public Consumer<ConsumerRecord<?, ?>> consume() {
        return (consume) -> System.out.println("Consumer for topic1 " + consume.toString());
    }

}
