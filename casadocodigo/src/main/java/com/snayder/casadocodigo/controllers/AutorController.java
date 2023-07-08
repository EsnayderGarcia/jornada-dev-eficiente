package com.snayder.casadocodigo.controllers;

import com.snayder.casadocodigo.domain.Autor;
import com.snayder.casadocodigo.domain.dtos.AutorRequest;
import com.snayder.casadocodigo.domain.dtos.AutorResponse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("autores")
//3 pontos de entendimento
public class AutorController {
    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public AutorResponse salvar(@RequestBody @Valid AutorRequest request) {
        Autor novoAutor = manager.merge(request.toModel());
        return new AutorResponse(novoAutor);
    }
}
