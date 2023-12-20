package umc.spring.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.Repository.MissionRepository;
import umc.spring.Repository.RestaurantRepository;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.RestaurantHandler;
import umc.spring.domain.Missions;
import umc.spring.domain.Restaurant;
import umc.spring.web.dto.mission.MissionRequestDTO;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService{
    private final MissionRepository missionRepository;
    private final RestaurantRepository restaurantRepository;

    @Override
    @Transactional
    public Missions addMission(MissionRequestDTO.AddMissionDTO request) {
        Restaurant restaurant = restaurantRepository.findById(request.getRestaurantId())
                .orElseThrow(() -> new RestaurantHandler(ErrorStatus.RESTAURANT_NOT_FOUND));
        Missions missions = Missions.builder()
                .reward(request.getReward())
                .description(request.getDescription())
                .deadline(request.getDeadline())
                .restaurant(restaurant)
                .build();
        missionRepository.save(missions);
        return missions;
    }
}
