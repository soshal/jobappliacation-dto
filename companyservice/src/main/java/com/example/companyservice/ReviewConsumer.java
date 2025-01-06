package com.example.companyservice;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ReviewConsumer {


    private final CompanyService companyService;

    public ReviewConsumer(CompanyService companyService) {
        this.companyService = companyService;
    }

    @RabbitListener(queues = "companyRatingQueue")
    public void receiveReview(ReviewMessage reviewMessage) {
        companyService.updateCompany(reviewMessage);
    }

}