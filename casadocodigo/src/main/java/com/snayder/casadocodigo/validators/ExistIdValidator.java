package com.snayder.casadocodigo.validators;

import com.snayder.casadocodigo.annotations.ExistId;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ExistIdValidator implements ConstraintValidator<ExistId, Object> {
    private Class<?> klass;

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void initialize(ExistId annotation) {
        klass = annotation.domainClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
       return value == null || manager.find(klass, value) != null;
    }
}
