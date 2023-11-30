package umcStudy.springStudy.service.StoreService;

import umcStudy.springStudy.web.dto.request.StoreRequest;

public interface StoreService {
    void AddStore(StoreRequest.AddStoreDTO addStoreDTO,Long regionId);

    boolean existsByName(String name);
}
