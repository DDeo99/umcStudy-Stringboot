package umcStudy.springStudy.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umcStudy.springStudy.apiPayload.ApiResponse;
import umcStudy.springStudy.domain.Mission;
import umcStudy.springStudy.service.MemberMissionService.MemberMissionService;
import umcStudy.springStudy.service.MemberService.MemberCommandService;
import umcStudy.springStudy.service.MissionService.MissionService;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class MemberMissionController {

    private final MemberMissionService memberMissionService;

    @PostMapping("/members/{memberId}/mission")
    public ApiResponse<String> AddMemberMission (@PathVariable ("memberId") Long memberId,
                                                @RequestParam("missionId") Long missionId) {
            memberMissionService.AddMemberMission(memberId, missionId);
            return ApiResponse.onSuccess(null);
    }
}
