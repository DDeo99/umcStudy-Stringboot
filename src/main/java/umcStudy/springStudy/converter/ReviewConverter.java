package umcStudy.springStudy.converter;

import lombok.RequiredArgsConstructor;
import umcStudy.springStudy.domain.Review;
import umcStudy.springStudy.web.dto.request.ReviewRequest;

public class ReviewConverter {

    public static Review toReview(ReviewRequest.AddReivewDTO request) {
        return Review.builder()
                .head(request.getReviewHead())
                .body(request.getReviewBody())
                .score(request.getScore())
                .build();
    }
}
