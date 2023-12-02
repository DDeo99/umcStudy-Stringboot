package umcStudy.springStudy.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;
import umcStudy.springStudy.apiPayload.code.status.ErrorStatus;
import umcStudy.springStudy.validation.annotation.CheckMissionStatus;
import umcStudy.springStudy.validation.annotation.CheckPaging;

@Component
public class PagingValidator implements ConstraintValidator<CheckPaging, Integer> {
    @Override
    public void initialize(CheckPaging constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {

        boolean isValid = value!=null && value >=1;

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.PAGING_BAD_REQUEST.toString()).addConstraintViolation();
        }

        return isValid;
    }
}
