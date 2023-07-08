package com.snayder.casadocodigo.validators;

import com.snayder.casadocodigo.domain.Autor;
import com.snayder.casadocodigo.domain.dtos.AutorRequest;
import com.snayder.casadocodigo.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ProibeEmailAutorDuplicadoValidator implements Validator {
    @Autowired
    private AutorRepository autorRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return AutorRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()) return;

        AutorRequest request = (AutorRequest) target;
        Optional<Autor> possivelAutor = autorRepository.findByEmail(request.getEmail());

        if(possivelAutor.isPresent())
            errors.rejectValue("Email", null, "O email "+request.getEmail()+" já está registrado em nosso sistema");
    }
}
