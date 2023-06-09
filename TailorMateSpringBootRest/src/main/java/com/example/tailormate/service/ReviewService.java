package com.example.tailormate.service;

import com.example.tailormate.model.Colors;
import com.example.tailormate.model.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews();
    Review getReviewById(int id);
    Review saveReview(Review review);
    Review updateReview(Review review);
    void deleteReview(int id);
}
