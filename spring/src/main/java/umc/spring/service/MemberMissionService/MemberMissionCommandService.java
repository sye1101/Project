package umc.spring.service.MemberMissionService;

import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.memberMission.MemberMissionRequestDTO;

public interface MemberMissionCommandService {
    public MemberMission addMemberMission(MemberMissionRequestDTO.AddMemberMissionDTO request);
}
