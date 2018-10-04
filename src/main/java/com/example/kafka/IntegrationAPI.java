package com.example.kafka;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IntegrationAPI {

    @Autowired
    private KafkaMailProducer kafkaMailProducer;

    @PostMapping("/sendEmail")
    public ResponseEntity<String> sendMessage(@RequestBody Request request) {
        kafkaMailProducer.produceMail().accept(request);
        return new ResponseEntity<>("Message sent to " + request.toEmail, HttpStatus.OK);
    }
    /**
     * 
     * @param requests List of request to send an email.
     * @return
     */
    @PostMapping("/bulkEmail")
    public List<ResponseEntity<String>> sendMessage(@RequestBody List<Request> requests) {
        List<ResponseEntity<String>> responses= new ArrayList<>();
        requests.forEach((request)-> {
            kafkaMailProducer.produceMail().accept(request);
            responses.add(new ResponseEntity<>("Message sent to " + request.toEmail, HttpStatus.OK));
        });
        return responses;
    }

}
