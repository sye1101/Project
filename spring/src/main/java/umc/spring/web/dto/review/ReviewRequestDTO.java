package umc.spring.web.dto.review;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ReviewRequestDTO {
    @Getter
    public static class AddReview {
        @NotNull
        Long restaurantId;
        @NotBlank
        String body;
        @NotNull
        float rating;
    }
}
