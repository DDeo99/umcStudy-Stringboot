package umcStudy.springStudy.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umcStudy.springStudy.apiPayload.ApiResponse;
import umcStudy.springStudy.converter.MissionConverter;
import umcStudy.springStudy.converter.ReviewConverter;
import umcStudy.springStudy.domain.Mission;
import umcStudy.springStudy.domain.Review;
import umcStudy.springStudy.service.MissionService.MissionService;
import umcStudy.springStudy.validation.annotation.CheckPaging;
import umcStudy.springStudy.web.dto.request.MissionRequest;
import umcStudy.springStudy.web.dto.response.MemberResponseDTO;
import umcStudy.springStudy.web.dto.response.MissionResponseDTO;

@RestController
@RequestMapping("/missions")
@RequiredArgsConstructor
public class MissionRestController {

    private final MissionService missionService;

    @PostMapping("/stores/{store_id}")
    public ApiResponse<String> AddMission(@PathVariable("store_id") Long storeId,
                                          @RequestBody @Valid MissionRequest.AddMissionDTO request) {

        missionService.AddMission(request, storeId);

        return ApiResponse.onSuccess(null);
    }

    @GetMapping("/members/{memberId}")

    public ApiResponse<MissionResponseDTO.MissionListDTO> getMyMissionList(@PathVariable("memberId") Long memberId,
                                                                           @RequestParam(name="page") @CheckPaging Integer page) {

        Page<Mission> missionPage = missionService.getMyMissionList(memberId, page-1);
        MissionResponseDTO.MissionListDTO missionListDTO = MissionConverter.missionListDTO(missionPage);
        return ApiResponse.onSuccess(missionListDTO);
    }

    @PostMapping("/{missionId}")
    public ApiResponse<String> completeMission(@RequestParam("missionId") Long missionId) {
        missionService.completeMission(missionId);

        return ApiResponse.onSuccess(null);
    }

}
