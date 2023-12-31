package com.snayder.casadocodigo.endereco.estado;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("estados")
//3 pontos de entendimento
public class EstadoResource {
    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public EstadoResponse salvar(@RequestBody @Valid EstadoRequest request) {
        Estado novoEstado = manager.merge(request.toModel(manager));
        return new EstadoResponse(novoEstado);
    }
}
