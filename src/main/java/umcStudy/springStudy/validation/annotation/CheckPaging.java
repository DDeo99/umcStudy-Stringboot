package umcStudy.springStudy.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umcStudy.springStudy.validation.validator.PagingValidator;
import umcStudy.springStudy.validation.validator.StoreExistValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PagingValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckPaging {
    String message() default "page의 범위가 너무 작습니다. page는 1 이상";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
