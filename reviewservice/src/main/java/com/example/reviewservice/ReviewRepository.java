package com.example.reviewservice;



import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    // Custom queries can be added here if needed
}
