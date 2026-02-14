package com.example.hrms.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class DocumentMessageConsumer {

    @RabbitListener(queues = "document.queue")
    public void receiveMessage(String message) {

        System.out.println("Processing: " + message);

        // simulate processing
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Document processed + Email sent!");
    }
}
