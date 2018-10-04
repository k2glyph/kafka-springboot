package com.example.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;


@Service
public class KafkaMailConsumer {

    @Autowired
    private EmailServer emailServer;

    @KafkaListener(topics = "${email.topic}", groupId = "${email.groupId}")
    public void consumeMessage(@Payload Request request) {
        System.out.println("----- CONSUMER -----");
        emailServer.sendMail(request);
        System.out.println("Message sent to " + request.toString());
    }
}
