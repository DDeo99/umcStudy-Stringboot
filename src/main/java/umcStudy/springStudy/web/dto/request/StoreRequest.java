package umcStudy.springStudy.web.dto.request;

import lombok.Getter;
import umcStudy.springStudy.domain.Region;

public class StoreRequest {

    @Getter
    public static class AddStoreDTO {
        private String store_name;
        private String store_address;
    }

}
