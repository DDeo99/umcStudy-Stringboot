package umcStudy.springStudy.service.MissionService;

import org.springframework.data.domain.Page;
import umcStudy.springStudy.domain.Mission;
import umcStudy.springStudy.web.dto.request.MissionRequest;

public interface MissionService {
    void AddMission(MissionRequest.AddMissionDTO request, Long storeId);

    Page<Mission> getMyMissionList(Long memberId, Integer page);
}
