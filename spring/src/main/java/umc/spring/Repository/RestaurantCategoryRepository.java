package umc.spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.RestaurantCategory;

public interface RestaurantCategoryRepository extends JpaRepository<RestaurantCategory, Long> {
}
