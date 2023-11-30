package umcStudy.springStudy.web.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import umcStudy.springStudy.domain.Region;
import umcStudy.springStudy.validation.annotation.ExistCategories;
import umcStudy.springStudy.validation.annotation.ExistStore;

public class StoreRequest {

    @Getter
    public static class AddStoreDTO {
        @NotNull
        @ExistStore
        private String store_name;
        @Size(min=5, max=12)
        private String store_address;
    }

}
