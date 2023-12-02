package umcStudy.springStudy.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import umcStudy.springStudy.domain.Mission;
import umcStudy.springStudy.domain.Region;
import umcStudy.springStudy.domain.Review;
import umcStudy.springStudy.domain.Store;
import umcStudy.springStudy.service.RegionService.RegionService;
import umcStudy.springStudy.web.dto.request.StoreRequest;
import umcStudy.springStudy.web.dto.response.MemberResponseDTO;
import umcStudy.springStudy.web.dto.response.StoreResponseDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class StoreConverter {


    public static Store toStore(StoreRequest.AddStoreDTO request) {
        return Store.builder()
                .address(request.getStore_address())
                .name(request.getStore_name())
                .build();
    }


    public static StoreResponseDTO.CreateMissionResultDTO toCreateMissionResultDTO(Mission mission){
        return StoreResponseDTO.CreateMissionResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static StoreResponseDTO.MissionDTO missionDTO(Mission mission){
        return StoreResponseDTO.MissionDTO.builder()
                .missionSpec(mission.getMission_spec())
                .reward(mission.getReward())
                .createdAt(mission.getCreatedAt().toLocalDate())
                .deadLine(mission.getCreatedAt().toLocalDate())
                .build();
    }
    public static StoreResponseDTO.MissionListDTO missionListDTO(Page<Mission> missionList){
        List<StoreResponseDTO.MissionDTO> missionDTOList = missionList.stream()
                .map(StoreConverter::missionDTO)
                .collect(Collectors.toList());

        return StoreResponseDTO.MissionListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionDTOList.size())
                .missionList(missionDTOList)
                .build();
    }

}
