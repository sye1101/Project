package umc.spring.web.dto.memberMission;

import lombok.Getter;
import javax.validation.constraints.NotNull;

public class MemberMissionRequestDTO {
    @Getter
    public static class AddMemberMissionDTO {
        @NotNull
        Long memberId;
        @NotNull
        Long missionId;
    }
}
