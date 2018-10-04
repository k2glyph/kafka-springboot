package com.example.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class IntegrationAPI {

    @Autowired
    private KafkaMailProducer kafkaMailProducer;

    @PostMapping("/sendEmail")
    public ResponseEntity sendMessage(@RequestBody Request request) {
        kafkaMailProducer.produceMail().accept(request);
        return new ResponseEntity<>("Message sent to " + request.toEmail, HttpStatus.OK);
    }

}
