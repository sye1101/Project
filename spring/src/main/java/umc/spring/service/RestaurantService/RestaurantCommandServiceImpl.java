package umc.spring.service.RestaurantService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.Repository.LocationRepository;
import umc.spring.Repository.RestaurantCategoryRepository;
import umc.spring.Repository.RestaurantRepository;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.LocationHandler;
import umc.spring.apiPayload.exception.handler.RestaurantCategoryHandler;
import umc.spring.domain.Location;
import umc.spring.domain.Restaurant;
import umc.spring.domain.RestaurantCategory;
import umc.spring.web.dto.RestaurantRequestDTO;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RestaurantCommandServiceImpl implements RestaurantCommandService{
    private final RestaurantRepository restaurantRepository;
    private final RestaurantCategoryRepository restaurantCategoryRepository;
    private final LocationRepository locationRepository;

    @Override
    @Transactional
    public Restaurant addRestaurant(RestaurantRequestDTO.AddRestaurantDTO request) {
        Location location = locationRepository.findById(request.getLocationId())
                .orElseThrow(() -> new LocationHandler(ErrorStatus.LOCATION_NOT_FOOUND));
        RestaurantCategory restaurantCategory = restaurantCategoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new RestaurantCategoryHandler(ErrorStatus.RESTAURANT_CATEGORY_NOT_FOUND));

        Restaurant restaurant = Restaurant.builder()
                .name(request.getName())
                .restaurantCategory(restaurantCategory)
                .location(location)
                .address(request.getAddress())
                .build();
        restaurantRepository.save(restaurant);
        return restaurant;
    }
}