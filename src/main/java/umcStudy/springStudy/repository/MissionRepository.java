package umcStudy.springStudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umcStudy.springStudy.domain.Mission;

@Repository
public interface MissionRepository extends JpaRepository<Mission,Long> {

}
