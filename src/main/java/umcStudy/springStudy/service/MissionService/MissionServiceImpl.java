package umcStudy.springStudy.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import org.webjars.NotFoundException;
import umcStudy.springStudy.converter.MissionConverter;
import umcStudy.springStudy.domain.Mapping.MemberMission;
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

    public void completeMission(Long missionId) {

        Mission mission=missionRepository.findById(missionId)
                .orElseThrow(()->new NotFoundException("해당하는 미션이 없습니다."));

        MemberMission memberMission = memberMissionRepository.findByMissionId(missionId);

        if(memberMission.getStatus().equals("IN_PROGRESS")) {
            memberMission.setStatus("COMPLETE");
        }
        else if(memberMission.getStatus().equals("COMPLETE")){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"이미 완료된 미션입니다.");
        }
        else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"미션의 현재 상태에 대한 처리가 필요합니다.");
        }

        memberMissionRepository.save(memberMission);
    }


}
