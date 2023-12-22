package umc.spring.service.RestaurantService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.spring.Repository.RestaurantRepository;
import umc.spring.Repository.ReviewRepository;
import umc.spring.domain.Restaurant;
import umc.spring.domain.Review;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RestaurantQueryServiceImpl implements RestaurantQueryService{
    private final RestaurantRepository restaurantRepository;
    private final ReviewRepository reviewRepository;

    @Override
    public boolean isRestaurantExist(Long restaurantId) {
        return restaurantRepository.findById(restaurantId).isPresent();
    }

    @Override
    public Optional<Restaurant> findRestaurant(Long id) {
        return restaurantRepository.findById(id);
    }

    @Override
    public Page<Review> getReviewList(Long RestaurantId, Integer page) {
        Restaurant restaurant = restaurantRepository.findById(RestaurantId).get();
        Page<Review> RestaurantPage = reviewRepository.findAllByRestaurant(restaurant, PageRequest.of(page, 10));
        return RestaurantPage;
    }
}
