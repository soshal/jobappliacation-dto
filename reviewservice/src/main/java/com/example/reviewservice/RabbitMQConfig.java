package com.example.reviewservice;


import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue reviewQueue() {
        return new Queue("companyRatingQueue", false);
    }
}
