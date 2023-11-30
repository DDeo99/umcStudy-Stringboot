package umcStudy.springStudy.service.FoodCategoryService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umcStudy.springStudy.repository.FoodCategoryRepository;

@Service
@RequiredArgsConstructor
public class FoodCategoryCommandServiceImpl implements FoodCategoryCommandService{

    private final FoodCategoryRepository foodCategoryRepository;

    public boolean existsById(Long id) {
        return foodCategoryRepository.existsById(id);
    }
}
