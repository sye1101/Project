package umc.spring.web.dto.restaurant;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class RestaurantRequestDTO {
    @Getter
    public static class AddRestaurantDTO{
        @NotBlank
        String name;
        @NotNull
        Long categoryId;
        @NotNull
        Long locationId;
        @NotNull
        String address;
    }

    @Getter
    public static class ReviewDTO {
        @NotNull
        Float rating;
        @NotBlank
        String body;
    }
}
