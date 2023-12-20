package umc.spring.service.MissionService;

import umc.spring.domain.Missions;
import umc.spring.web.dto.mission.MissionRequestDTO;

public interface MissionCommandService {
    public Missions addMission(MissionRequestDTO.AddMissionDTO request);
}
