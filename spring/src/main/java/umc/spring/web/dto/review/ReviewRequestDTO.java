package umc.spring.web.dto.review;

import lombok.Getter;
import umc.spring.validation.annotation.ExistRestaurant;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ReviewRequestDTO {
    @Getter
    public static class AddReview {
        @ExistRestaurant
        Long restaurantId;
        @NotBlank
        String body;
        @NotNull
        float rating;
    }
}