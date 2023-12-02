package umcStudy.springStudy.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import umcStudy.springStudy.domain.Mission;
import umcStudy.springStudy.repository.MissionRepository;
import umcStudy.springStudy.web.dto.request.MissionRequest;
import umcStudy.springStudy.web.dto.response.MissionResponseDTO;
import umcStudy.springStudy.web.dto.response.StoreResponseDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class MissionConverter {

    public static Mission toMission(MissionRequest.AddMissionDTO request) {
        return Mission.builder()
                .deadline(request.getDeadline())
                .mission_spec(request.getMission_spec())
                .reward(request.getReward())
                .build();
    }

    public static MissionResponseDTO.CreateMissionResultDTO toCreateMissionResultDTO(Mission mission){
        return MissionResponseDTO.CreateMissionResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static MissionResponseDTO.MissionDTO missionDTO(Mission mission){
        return MissionResponseDTO.MissionDTO.builder()
                .missionSpec(mission.getMission_spec())
                .reward(mission.getReward())
                .createdAt(mission.getCreatedAt().toLocalDate())
                .deadLine(mission.getCreatedAt().toLocalDate())
                .build();
    }
    public static MissionResponseDTO.MissionListDTO missionListDTO(Page<Mission> missionList){
        List<MissionResponseDTO.MissionDTO> missionDTOList = missionList.stream()
                .map(MissionConverter::missionDTO)
                .collect(Collectors.toList());

        return MissionResponseDTO.MissionListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionDTOList.size())
                .missionList(missionDTOList)
                .build();
    }
}
