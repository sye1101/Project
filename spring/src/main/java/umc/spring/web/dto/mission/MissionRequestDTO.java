package umc.spring.web.dto.mission;

import lombok.Getter;
import umc.spring.validation.annotation.ExistRestaurant;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class MissionRequestDTO {
    @Getter
    public static class AddMissionDTO {
        @NotNull
        Integer reward;
        @NotBlank
        String description;
        @NotNull
        LocalDate deadline;
        @ExistRestaurant
        Long restaurantId;
    }
}
