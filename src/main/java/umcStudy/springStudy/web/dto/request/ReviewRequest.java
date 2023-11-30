package umcStudy.springStudy.web.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class ReviewRequest {

    @Getter
    public static class AddReivewDTO {
        @NotNull
        private String review;
    }
}
