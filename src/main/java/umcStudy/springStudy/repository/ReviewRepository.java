package umcStudy.springStudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umcStudy.springStudy.domain.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
}
