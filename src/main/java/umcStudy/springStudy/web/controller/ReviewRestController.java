package umcStudy.springStudy.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umcStudy.springStudy.apiPayload.ApiResponse;
import umcStudy.springStudy.service.ReviewService.ReviewService;
import umcStudy.springStudy.web.dto.request.ReviewRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewRestController {

    private final ReviewService reviewService;

    @PostMapping("/{store_id}")
    public ApiResponse<String> AddReview(@PathVariable("store_id") Long storeId,
                                         @RequestBody @Valid ReviewRequest.AddReivewDTO request) {

        reviewService.AddReview(request,storeId);

        return ApiResponse.onSuccess(null);
    }
}
