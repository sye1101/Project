package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Restaurant;
import umc.spring.domain.Review;
import umc.spring.web.dto.restaurant.RestaurantRequestDTO;
import umc.spring.web.dto.restaurant.RestaurantResponseDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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

    public static Review toReview(RestaurantRequestDTO.ReviewDTO request) {
        return Review.builder()
                .rating(request.getRating())
                .body(request.getBody())
                .build();
    }

    public static RestaurantResponseDTO.CreateReviewResultDTO toCreateReviewResultDTO(Review review) {
        return RestaurantResponseDTO.CreateReviewResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static RestaurantResponseDTO.ReviewPreViewDTO reviewPreViewDTO(Review review) {
        return RestaurantResponseDTO.ReviewPreViewDTO.builder()
                .ownerNickname(review.getMember().getNickname())
                .rating(review.getRating())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getBody())
                .build();
    }

    public static RestaurantResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO(Page<Review> reviewList){

        List<RestaurantResponseDTO.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(RestaurantConverter::reviewPreViewDTO).collect(Collectors.toList());

        return RestaurantResponseDTO.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }
}
