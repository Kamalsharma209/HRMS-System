package com.example.hrms.service;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailProducer {

    private final RabbitTemplate rabbitTemplate;

    public void sendWelcomeEmail(String email, String name) {

        String message = email + "," + name;

        rabbitTemplate.convertAndSend(
                "email.queue",
                message
        );

        System.out.println("Welcome email queued for " + email);
    }
}
