package umcStudy.springStudy.web.controller;

import io.swagger.v3.oas.annotations.Operation;
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
import umcStudy.springStudy.domain.Review;
import umcStudy.springStudy.service.MemberService.MemberCommandService;
import umcStudy.springStudy.service.ReviewService.ReviewService;
import umcStudy.springStudy.service.StoreService.StoreQueryService;
import umcStudy.springStudy.validation.annotation.ExistStore;
import umcStudy.springStudy.web.dto.request.ReviewRequest;
import umcStudy.springStudy.web.dto.response.MemberResponseDTO;
import umcStudy.springStudy.web.dto.response.StoreResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class ReviewRestController {

    private final ReviewService reviewService;
    private final StoreQueryService storeQueryService;
    private final MemberCommandService memberCommandService;

    @PostMapping("/{store_id}/reviews")
    public ApiResponse<String> AddReview(@PathVariable("store_id") Long storeId,
                                         @RequestBody @Valid ReviewRequest.AddReivewDTO request) {

        reviewService.AddReview(request,storeId);

        return ApiResponse.onSuccess(null);
    }

    @Operation(summary = "특정 가게의 리뷰 목록 조회 API",description = "특정 가게의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @GetMapping("/stores/{storeId}/reviews")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!"),
            @Parameter(name = "page", description = "페이지 번호, 0번이 1 페이지 입니다.", example = "1"),
    })
    public ApiResponse<StoreResponseDTO.ReviewPreViewListDTO> getReviewList(@PathVariable(name = "storeId") Long storeId, @RequestParam(name = "page") Integer page){
        Page<Review> reviewPage = storeQueryService.getReviewList(storeId,page);
        StoreResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO = ReviewConverter.reviewPreViewListDTO(reviewPage);
        return ApiResponse.onSuccess(reviewPreViewListDTO);
    }

    @GetMapping("/members/{memberId}/reviews")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name="memberId", description = "회원 아이디, path variable입니다."),
            @Parameter(name = "page", description = "페이지 번호, 0번이 1 페이지 입니다.", example = "1"),
    })
    public ApiResponse<MemberResponseDTO.ReviewListDTO> getMemberReviewList(@PathVariable(name="memberId") Long memberId, @RequestParam(name="page") Integer page){
        Page<Review> reviewPage = memberCommandService.getReviewList(memberId, page);
        MemberResponseDTO.ReviewListDTO reviewListDTO = ReviewConverter.reviewListDTO(reviewPage);
        return ApiResponse.onSuccess(reviewListDTO);
    }
}
