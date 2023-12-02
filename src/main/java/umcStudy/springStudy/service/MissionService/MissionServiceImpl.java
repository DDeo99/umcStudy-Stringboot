package umcStudy.springStudy.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;
import umcStudy.springStudy.converter.MissionConverter;
import umcStudy.springStudy.domain.Member;
import umcStudy.springStudy.domain.Mission;
import umcStudy.springStudy.domain.Review;
import umcStudy.springStudy.repository.MemberMissionRepository;
import umcStudy.springStudy.repository.MemberRepository;
import umcStudy.springStudy.repository.MissionRepository;
import umcStudy.springStudy.repository.StoreRepository;
import umcStudy.springStudy.web.dto.request.MissionRequest;

@Service
@Transactional
@RequiredArgsConstructor
public class MissionServiceImpl implements MissionService{

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;
    private final MemberMissionRepository memberMissionRepository;

    public void AddMission(MissionRequest.AddMissionDTO request, Long storeId) {
        Mission mission = MissionConverter.toMission(request);
        mission.setStore(storeRepository.findById(storeId)
                .orElseThrow(()-> new NotFoundException("해당하는 가게가 없습니다.")));

        missionRepository.save(mission);
    }

    public Page<Mission> getMyMissionList(Long memberId, Integer page) {

        Member member = memberRepository.findById(memberId).orElseThrow(()-> new NotFoundException("해당하는 멤버가 없습니다."));

        Page<Mission> MissionPage = memberMissionRepository.findInProgressMissionsByMember(member, PageRequest.of(page, 10));
        return MissionPage;

    }


}
