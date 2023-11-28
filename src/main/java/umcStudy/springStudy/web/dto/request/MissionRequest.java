package umcStudy.springStudy.web.dto.request;

import lombok.Getter;

import java.time.LocalDate;

public class MissionRequest {

    @Getter
    public static class AddMissionDTO {
        private LocalDate deadline;
        private Integer reward;
        private String mission_spec;
    }
}
