package com.example.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class EmailServer {

    @Autowired
    private JavaMailSender mailSender;

    public void sendMail(Request request) {
        mailSender.send(setMessage().apply(request));
    }

    private Function<Request, SimpleMailMessage> setMessage() {
        return (request) -> {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(request.toEmail);
            mailMessage.setFrom(request.from);
            mailMessage.setSubject(request.subject);
            mailMessage.setText(request.message);
            return mailMessage;
        };
    }

}
