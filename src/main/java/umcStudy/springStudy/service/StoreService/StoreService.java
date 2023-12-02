package umcStudy.springStudy.service.StoreService;

import org.springframework.data.domain.Page;
import umcStudy.springStudy.domain.Mission;
import umcStudy.springStudy.web.dto.request.StoreRequest;

public interface StoreService {
    void AddStore(StoreRequest.AddStoreDTO addStoreDTO,Long regionId);

    boolean existsByName(String name);

    Page<Mission> getMissionList(Long storeId, Integer page);
}
