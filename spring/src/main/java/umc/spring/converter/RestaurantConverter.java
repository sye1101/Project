package umc.spring.converter;

import umc.spring.domain.Restaurant;
import umc.spring.web.dto.RestaurantResponseDTO;

public class RestaurantConverter {
    public static RestaurantResponseDTO.AddRestaurantResultDTO toAddRestaurantResultDTO(Restaurant restaurant) {
        return RestaurantResponseDTO.AddRestaurantResultDTO.builder()
                .restaurantId(restaurant.getId())
                .name(restaurant.getName())
                .categoryId(restaurant.getRestaurantCategory().getId())
                .locationId(restaurant.getLocation().getId())
                .address(restaurant.getAddress())
                .build();
    }
}
