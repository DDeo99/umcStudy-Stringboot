package umcStudy.springStudy.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umcStudy.springStudy.domain.Review;
import umcStudy.springStudy.domain.Store;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    Page<Review> findAllByStore(Store store, PageRequest pageRequest);
}
