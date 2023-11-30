package umcStudy.springStudy.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import umcStudy.springStudy.validation.annotation.ExistCategories;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class MissionStatusValidator implements ConstraintValidator<ExistCategories, String> {
    @Override
    public void initialize(ExistCategories constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (!value.equals("InProgress")) {
            // 미션이 "InProgress" 상태가 아니라면 유효하지 않음
            return false;
        }

        return true;
    }
}
