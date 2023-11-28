package umcStudy.springStudy.service.ReviewService;

import umcStudy.springStudy.web.dto.request.ReviewRequest;

public interface ReviewService {
    void AddReview(ReviewRequest.AddReivewDTO request, Long storeId);
}
