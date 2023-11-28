package umcStudy.springStudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umcStudy.springStudy.domain.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {

}
