package umc.spring.service.RestaurantService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Restaurant;
import umc.spring.domain.Review;

import java.util.Optional;

public interface RestaurantQueryService {
    boolean isRestaurantExist(Long restaurantId);

    Optional<Restaurant> findRestaurant(Long id);
    Page<Review> getReviewList(Long RestaurantId, Integer page);
}
