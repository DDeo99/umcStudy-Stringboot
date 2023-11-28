package umcStudy.springStudy.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;
import umcStudy.springStudy.converter.MissionConverter;
import umcStudy.springStudy.domain.Mission;
import umcStudy.springStudy.repository.MissionRepository;
import umcStudy.springStudy.repository.StoreRepository;
import umcStudy.springStudy.web.dto.request.MissionRequest;

@Service
@Transactional
@RequiredArgsConstructor
public class MissionServiceImpl implements MissionService{

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;

    public void AddMission(MissionRequest.AddMissionDTO request, Long storeId) {
        Mission mission = MissionConverter.toMission(request);
        mission.setStore(storeRepository.findById(storeId)
                .orElseThrow(()-> new NotFoundException("해당하는 가게가 없습니다.")));

        missionRepository.save(mission);
    }
}
