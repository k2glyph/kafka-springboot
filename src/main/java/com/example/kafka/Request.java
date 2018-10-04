package com.example.kafka;


import java.io.Serializable;

public class Request implements Serializable {

    public String toEmail,  subject, message, from;

    public Request() {}

    public Request(String toEmail, String subject, String message, String from) {
        this.toEmail = toEmail;
        this.subject = subject;
        this.message = message;
        this.from = from;
    }

    @Override
    public String toString() {
        return "to email: " + toEmail +
                " subject: " + subject +
                " message: " + message +
                " from: " + from;
    }
}
