package umcStudy.springStudy.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umcStudy.springStudy.apiPayload.ApiResponse;
import umcStudy.springStudy.service.MissionService.MissionService;
import umcStudy.springStudy.web.dto.request.MissionRequest;

@RestController
@RequestMapping("/missions")
@RequiredArgsConstructor
public class MissionRestController {

    private final MissionService missionService;

    @PostMapping("/{store_id}")
    public ApiResponse<String> AddMission(@PathVariable("store_id") Long storeId,
                                          @RequestBody @Valid MissionRequest.AddMissionDTO request) {

        missionService.AddMission(request, storeId);

        return ApiResponse.onSuccess(null);
    }

}
