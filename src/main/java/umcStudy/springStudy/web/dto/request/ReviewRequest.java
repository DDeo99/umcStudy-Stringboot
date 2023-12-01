package umcStudy.springStudy.web.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

public class ReviewRequest {

    @Getter
    public static class AddReivewDTO {
        @NotNull
        private String reviewHead;
        @NotNull
        private String reviewBody;
        @NotNull
        @Min(0)@Max(5)
        private float score;
    }
}
