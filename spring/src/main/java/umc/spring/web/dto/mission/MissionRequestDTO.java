package umc.spring.web.dto.mission;

import lombok.Getter;

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
        @NotNull
        Long restaurantId;
    }
}
