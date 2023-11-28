package umcStudy.springStudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umcStudy.springStudy.domain.FoodCategory;

@Repository
public interface FoodCategoryRepository extends JpaRepository<FoodCategory,Long> {
}
