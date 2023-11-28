package umcStudy.springStudy.service.StoreService;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;
import umcStudy.springStudy.converter.StoreConverter;
import umcStudy.springStudy.domain.Store;
import umcStudy.springStudy.repository.MemberRepository;
import umcStudy.springStudy.repository.RegionRepository;
import umcStudy.springStudy.repository.StoreRepository;
import umcStudy.springStudy.service.RegionService.RegionService;
import umcStudy.springStudy.web.dto.request.StoreRequest;

@Service
@Transactional
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService{

    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;

    public void AddStore(StoreRequest.AddStoreDTO addStoreDTO,Long regionId) {
        Store store = StoreConverter.toStore(addStoreDTO);
        store.setRegion(regionRepository.findById(regionId)
                .orElseThrow(()->new NotFoundException("해당하는 지역이 없습니다.")));

        storeRepository.save(store);
    }
}
