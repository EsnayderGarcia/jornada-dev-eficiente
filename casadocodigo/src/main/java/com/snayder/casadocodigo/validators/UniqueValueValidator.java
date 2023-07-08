package com.snayder.casadocodigo.validators;

import com.snayder.casadocodigo.annotations.UniqueValue;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class UniqueValueValidator implements ConstraintValidator<UniqueValue, Object> {
    private String fieldName;
    private String message;
    private Class<?> klass;

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void initialize(UniqueValue annotation) {
        fieldName = annotation.fieldName();
        message = annotation.message();
        klass = annotation.domainClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        return manager.createQuery("FROM "+klass.getName()+" WHERE "+fieldName+" = :value")
                .setParameter("value", value)
                .getResultList().isEmpty();
    }


}
