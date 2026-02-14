package com.example.hrms.service;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailConsumer {

    private final JavaMailSender mailSender;

    @RabbitListener(queues = "email.queue")
    public void sendEmail(String message) {

        String[] data = message.split(",");
        String email = data[0];
        String name = data[1];

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(email);
        mail.setSubject("Welcome to Company!");

        mail.setText(
                "Hi " + name + ",\n\n" +
                        "Welcome to our organization!\n" +
                        "We are excited to have you onboard.\n\n" +
                        "Regards,\nHR Team"
        );

        mailSender.send(mail);

        System.out.println("Welcome email sent to " + email);
    }
}
