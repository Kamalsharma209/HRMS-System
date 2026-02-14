package com.example.hrms.service;

import com.example.hrms.config.RabbitConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DocumentMessageProducer {

    private final RabbitTemplate rabbitTemplate;

    public void sendDocumentMessage(String empCode, String docName) {

        String message = "Employee " + empCode +
                " uploaded document: " + docName;

        rabbitTemplate.convertAndSend(
                RabbitConfig.QUEUE,
                message
        );

        System.out.println("Message sent: " + message);
    }
}
