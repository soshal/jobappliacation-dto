package com.example.reviewservice;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public Review saveReview(Review review) {
        return reviewRepository.save(review);
    }

    public Optional<Review> getReviewById(Long id) {
        return reviewRepository.findById(id);
    }

    public List<Review> getReviewsByJobId(Long jobId) {
        return reviewRepository.findAll().stream()
                .filter(review -> review.getJobId().equals(jobId))
                .toList();
    }

    public List<Review> getReviewsByCompanyId(Long companyId) {
        return reviewRepository.findAll().stream()
                .filter(review -> review.getCompanyId().equals(companyId))
                .toList();
    }

    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }
}
