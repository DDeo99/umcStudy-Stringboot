package umcStudy.springStudy.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import umcStudy.springStudy.apiPayload.code.status.ErrorStatus;
import umcStudy.springStudy.repository.FoodCategoryRepository;
import umcStudy.springStudy.service.FoodCategoryService.FoodCategoryCommandService;
import umcStudy.springStudy.validation.annotation.ExistCategories;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class CategoriesExistValidator implements ConstraintValidator<ExistCategories, List<Long>> {

    private final FoodCategoryCommandService foodCategoryService;
    @Override
    public void initialize(ExistCategories constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(List<Long> values, ConstraintValidatorContext context) {
        boolean isValid = values.stream()
                .allMatch(value -> foodCategoryService.existsById(value));

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.FOOD_CATEGORY_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;

    }
}
