package umcStudy.springStudy.service.StoreService;

import org.springframework.data.domain.Page;
import umcStudy.springStudy.domain.Review;
import umcStudy.springStudy.domain.Store;

import java.util.Optional;

public interface StoreQueryService {

    Optional<Store> findStore(Long id);

    Page<Review> getReviewList(Long StoreId, Integer page);
}