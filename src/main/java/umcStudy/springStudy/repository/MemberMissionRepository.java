package umcStudy.springStudy.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import umcStudy.springStudy.domain.Mapping.MemberMission;
import umcStudy.springStudy.domain.Member;
import umcStudy.springStudy.domain.Mission;

@Repository
public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {

    boolean existsByMemberIdAndMissionIdAndStatus(Long member_id, Long mission_id, String status);
    @Query("SELECT mm.mission FROM MemberMission mm WHERE mm.member = :member AND mm.status = 'IN_PROGRESS'")
    Page<Mission> findInProgressMissionsByMember(@Param("member") Member member, PageRequest pageRequest);

    MemberMission findByMissionId(Long missionId);
}
