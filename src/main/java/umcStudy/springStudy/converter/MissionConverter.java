package umcStudy.springStudy.converter;

import lombok.RequiredArgsConstructor;
import umcStudy.springStudy.domain.Mission;
import umcStudy.springStudy.repository.MissionRepository;
import umcStudy.springStudy.web.dto.request.MissionRequest;

public class MissionConverter {

    public static Mission toMission(MissionRequest.AddMissionDTO request) {
        return Mission.builder()
                .deadline(request.getDeadline())
                .mission_spec(request.getMission_spec())
                .reward(request.getReward())
                .build();
    }
}
