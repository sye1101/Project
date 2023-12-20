package umc.spring.converter;

import umc.spring.domain.Missions;
import umc.spring.web.dto.mission.MissionResponseDTO;

public class MissionConverter {
    public static MissionResponseDTO.AddMissionDTO toAddMissionDTO(Missions missions) {
        return MissionResponseDTO.AddMissionDTO.builder()
                .missionId(missions.getId())
                .restaurantId(missions.getRestaurant().getId())
                .reward(missions.getReward())
                .description(missions.getDescription())
                .deadline(missions.getDeadline())
                .build();
    }
}
