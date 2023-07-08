package com.snayder.casadocodigo.annotations;

import com.snayder.casadocodigo.validators.UniqueValueValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = {UniqueValueValidator.class})
@Target({FIELD})
@Retention(RUNTIME)
public @interface UniqueValue {
    String message();
    String fieldName();

    Class<?> domainClass();
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
