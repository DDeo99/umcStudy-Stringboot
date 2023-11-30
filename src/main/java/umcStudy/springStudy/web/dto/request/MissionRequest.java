package umcStudy.springStudy.web.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDate;

public class MissionRequest {

    @Getter
    public static class AddMissionDTO {
        @NotNull
        private LocalDate deadline;
        @NotNull
        private Integer reward;
        @NotNull
        private String mission_spec;
    }
}
