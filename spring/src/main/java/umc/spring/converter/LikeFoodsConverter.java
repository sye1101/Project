package umc.spring.converter;

import umc.spring.domain.FoodCategory;
import umc.spring.domain.mapping.LikeFoods;

import java.util.List;
import java.util.stream.Collectors;

public class LikeFoodsConverter {
    public static List<LikeFoods> toLikeFoodsList(List<FoodCategory> foodCategoryList){

        return foodCategoryList.stream()
                .map(foodCategory ->
                        LikeFoods.builder()
                                .foodCategory(foodCategory)
                                .build()
                ).collect(Collectors.toList());
    }
}
