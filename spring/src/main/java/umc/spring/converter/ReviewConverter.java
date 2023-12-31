package umc.spring.converter;

import umc.spring.domain.Review;
import umc.spring.web.dto.review.ReviewResponseDTO;

import java.time.LocalDateTime;

public class ReviewConverter {
    public static ReviewResponseDTO.AddReviewDTO toReviewDTO(Review review) {
        return ReviewResponseDTO.AddReviewDTO.builder()
                .restaurantId(review.getRestaurant().getId())
                .reviewId(review.getId())
                .body(review.getBody())
                .rating(review.getRating())
                .createdAt(LocalDateTime.now())
                .build();
    }
}