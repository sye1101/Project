package umc.spring.web.dto.restaurant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class RestaurantResponseDTO {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AddRestaurantResultDTO {
        Long restaurantId;
        String name;
        Long categoryId;
        Long locationId;
        String address;
    }
}