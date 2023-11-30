package umcStudy.springStudy.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;
import umcStudy.springStudy.converter.ReviewConverter;
import umcStudy.springStudy.domain.Review;
import umcStudy.springStudy.repository.ReviewRepository;
import umcStudy.springStudy.repository.StoreRepository;
import umcStudy.springStudy.web.dto.request.ReviewRequest;

@Service
@Transactional
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{

    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;

    public void AddReview(ReviewRequest.AddReivewDTO request, Long storeId) {
        Review review = ReviewConverter.toReview(request);
        review.setStore(storeRepository.findById(storeId)
                .orElseThrow(() -> new NotFoundException("해당하는 식당이 없습니다.")));

        reviewRepository.save(review);
    }
}
