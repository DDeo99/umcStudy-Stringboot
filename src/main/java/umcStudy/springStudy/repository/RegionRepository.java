package umcStudy.springStudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umcStudy.springStudy.domain.Region;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {

    Region findByName(String name);
}
