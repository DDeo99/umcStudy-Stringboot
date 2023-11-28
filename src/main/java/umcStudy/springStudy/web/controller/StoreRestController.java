package umcStudy.springStudy.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umcStudy.springStudy.apiPayload.ApiResponse;
import umcStudy.springStudy.converter.StoreConverter;
import umcStudy.springStudy.domain.Store;
import umcStudy.springStudy.service.RegionService.RegionService;
import umcStudy.springStudy.service.StoreService.StoreService;
import umcStudy.springStudy.web.dto.request.StoreRequest;
import umcStudy.springStudy.web.dto.response.MemberResponseDTO;

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
}
