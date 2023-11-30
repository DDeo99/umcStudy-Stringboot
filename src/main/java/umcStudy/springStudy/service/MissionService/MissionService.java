package umcStudy.springStudy.service.MissionService;

import umcStudy.springStudy.web.dto.request.MissionRequest;

public interface MissionService {
    void AddMission(MissionRequest.AddMissionDTO request, Long storeId);
}
