package com.example.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
public class KafkaMailProducer {

    @Value("${email.topic}")
    private String emailTopic;

    @Autowired
    private KafkaTemplate<String, Request> kafkaTemplateForMail;

    public Consumer<Request> produceMail() {
        return (request) -> {

            System.out.println("------ PRODUCER ------");
            System.out.println(request.toString());

            Message<Request> message = MessageBuilder
                    .withPayload(request)
                    .setHeader(KafkaHeaders.TOPIC, emailTopic).build();
            kafkaTemplateForMail.send(message);
        };
    }
}
