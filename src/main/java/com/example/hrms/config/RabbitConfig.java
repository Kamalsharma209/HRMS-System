package com.example.hrms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;

@Configuration
public class RabbitConfig {

    public static final String QUEUE = "document.queue";

    @Bean
    public Queue queue() {
        return new Queue(QUEUE, true);
    }
    @Bean
    public Queue emailQueue() {
        return new Queue("email.queue", true);
    }

}
