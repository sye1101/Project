package umc.spring.service.RestaurantService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.Repository.RestaurantRepository;

@Service
@RequiredArgsConstructor
public class RestaurantQueryServiceImpl implements RestaurantQueryService{
    private final RestaurantRepository restaurantRepository;

    @Override
    public boolean isRestaurantExist(Long restaurantId) {
        return restaurantRepository.findById(restaurantId).isPresent();
    }
}
