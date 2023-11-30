package umcStudy.springStudy.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import umcStudy.springStudy.apiPayload.code.status.ErrorStatus;
import umcStudy.springStudy.service.StoreService.StoreService;
import umcStudy.springStudy.validation.annotation.ExistStore;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class StoreExistValidator implements ConstraintValidator<ExistStore, String> {

    private final StoreService storeService;

    @Override
    public void initialize(ExistStore constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean isValid = storeService.existsByName(value);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.STORE_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;
    }
}
