package umcStudy.springStudy.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umcStudy.springStudy.validation.validator.MissionStatusValidator;

import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MissionStatusValidator.class)
public @interface CheckMissionStatus {
    String message() default "이미 진행중인 미션입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
