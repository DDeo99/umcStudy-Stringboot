package umcStudy.springStudy.service.MemberMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;
import umcStudy.springStudy.domain.Mapping.MemberMission;
import umcStudy.springStudy.domain.Member;
import umcStudy.springStudy.domain.Mission;
import umcStudy.springStudy.repository.MemberMissionRepository;
import umcStudy.springStudy.repository.MemberRepository;
import umcStudy.springStudy.repository.MissionRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberMissionServiceImpl implements MemberMissionService{

    private final MissionRepository missionRepository;
    private final MemberRepository memberRepository;
    private final MemberMissionRepository memberMissionRepository;

    public void AddMemberMission(Long memberId, Long missionId) {
        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new NotFoundException("해당하는 미션이 없습니다."));

        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new NotFoundException("해당하는 멤버가 없습니다."));

        boolean isMissionInProgress = memberMissionRepository.existsByMemberIdAndMissionIdAndStatus(memberId, missionId, "IN_PROGRESS");

        if (!isMissionInProgress) {
            MemberMission memberMission = MemberMission.builder()
                    .mission(mission)
                    .member(member)
                    .status("IN_PROGRESS")
                    .build();

            memberMissionRepository.save(memberMission);
        }
        else {
            throw new IllegalStateException("해당 미션은 이미 수행 중입니다.");
        }
    }

}
