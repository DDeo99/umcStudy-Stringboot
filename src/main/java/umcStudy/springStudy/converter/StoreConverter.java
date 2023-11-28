package umcStudy.springStudy.converter;

import lombok.RequiredArgsConstructor;
import umcStudy.springStudy.domain.Region;
import umcStudy.springStudy.domain.Store;
import umcStudy.springStudy.service.RegionService.RegionService;
import umcStudy.springStudy.web.dto.request.StoreRequest;

@RequiredArgsConstructor
public class StoreConverter {


    public static Store toStore(StoreRequest.AddStoreDTO request) {
        return Store.builder()
                .address(request.getStore_address())
                .name(request.getStore_name())
                .build();
    }


}
