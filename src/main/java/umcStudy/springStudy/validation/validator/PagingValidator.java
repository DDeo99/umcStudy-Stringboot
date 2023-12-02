package umcStudy.springStudy.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import umcStudy.springStudy.validation.annotation.CheckMissionStatus;
import umcStudy.springStudy.validation.annotation.CheckPaging;

public class PagingValidator implements ConstraintValidator<CheckPaging, Integer> {
    @Override
    public void initialize(CheckPaging constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {

        return value!=null && value >=1;
    }
}
