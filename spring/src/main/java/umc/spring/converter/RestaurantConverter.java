package umc.spring.converter;

import umc.spring.domain.Restaurant;
import umc.spring.web.dto.RestaurantReponseDTO;

public class RestaurantConverter {
    public static RestaurantReponseDTO.AddRestaurantResultDTO toAddRestaurantResultDTO(Restaurant restaurant) {
        return RestaurantReponseDTO.AddRestaurantResultDTO.builder()
                .restaurantId(restaurant.getId())
                .name(restaurant.getName())
                .categoryId(restaurant.getRestaurantCategory().getId())
                .locationId(restaurant.getLocation().getId())
                .address(restaurant.getAddress())
                .build();
    }
}
