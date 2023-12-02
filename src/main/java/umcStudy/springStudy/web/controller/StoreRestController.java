package umcStudy.springStudy.web.controller;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umcStudy.springStudy.apiPayload.ApiResponse;
import umcStudy.springStudy.converter.ReviewConverter;
import umcStudy.springStudy.converter.StoreConverter;
import umcStudy.springStudy.domain.Mission;
import umcStudy.springStudy.domain.Review;
import umcStudy.springStudy.domain.Store;
import umcStudy.springStudy.service.RegionService.RegionService;
import umcStudy.springStudy.service.StoreService.StoreService;
import umcStudy.springStudy.validation.annotation.CheckPaging;
import umcStudy.springStudy.web.dto.request.StoreRequest;
import umcStudy.springStudy.web.dto.response.MemberResponseDTO;
import umcStudy.springStudy.web.dto.response.StoreResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {

    private final StoreService storeService;
    private final RegionService regionService;

    @PostMapping("/{region_name}")
    public ApiResponse<String> AddStore(@PathVariable("region_name") String regionName,
                                        @RequestBody @Valid StoreRequest.AddStoreDTO request) {

        Long regionId = regionService.findByRegionIdByName(regionName);

        storeService.AddStore(request,regionId);
        return ApiResponse.onSuccess(null);
    }

    @GetMapping("/{storeId}/missions")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name="storeId", description = "가게 아이디, path variable입니다."),
            @Parameter(name = "page", description = "페이지 번호", example = "1"),
    })
    public ApiResponse<StoreResponseDTO .MissionListDTO> getStoreMissionList(@PathVariable(name="storeId") Long storeId, @RequestParam(name="page") @CheckPaging Integer page){
        Page<Mission> missionPage = storeService.getMissionList(storeId, page-1);
        StoreResponseDTO.MissionListDTO missionListDTO = StoreConverter.missionListDTO(missionPage);
        return ApiResponse.onSuccess(missionListDTO);
    }
}
