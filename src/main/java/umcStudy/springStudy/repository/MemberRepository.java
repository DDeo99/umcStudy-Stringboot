package umcStudy.springStudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umcStudy.springStudy.domain.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}
