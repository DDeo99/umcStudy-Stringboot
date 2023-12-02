package umcStudy.springStudy.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umcStudy.springStudy.domain.Mission;
import umcStudy.springStudy.domain.Review;
import umcStudy.springStudy.domain.Store;

@Repository
public interface MissionRepository extends JpaRepository<Mission,Long> {

    Page<Mission> findByStore(Store store, PageRequest pageRequest);

}
