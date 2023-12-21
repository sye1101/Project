package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.MemberMissionService.MemberMissionCommandService;
import umc.spring.web.dto.memberMission.MemberMissionRequestDTO;
import umc.spring.web.dto.memberMission.MemberMissionResponseDTO;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/memberMission")
public class MemberMissionRestController {
    private final MemberMissionCommandService memberMissionCommandService;

    @PostMapping("/")
    public ApiResponse<MemberMissionResponseDTO.AddMemberMissionDTO> add(@RequestBody @Valid MemberMissionRequestDTO.AddMemberMissionDTO request) {
        MemberMission memberMission = memberMissionCommandService.addMemberMission(request);
        return ApiResponse.onSuccess(MemberMissionConverter.toAddMemberMissionDTO(memberMission));
    }
}
