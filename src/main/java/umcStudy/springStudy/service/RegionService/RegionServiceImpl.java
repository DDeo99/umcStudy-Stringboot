package umcStudy.springStudy.service.RegionService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umcStudy.springStudy.domain.Region;
import umcStudy.springStudy.repository.RegionRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class RegionServiceImpl implements RegionService{

    private final RegionRepository regionRepository;

    public Long findByRegionIdByName(String regionName) {
        Region region = regionRepository.findByName(regionName);
        return region.getId();
    }
}
