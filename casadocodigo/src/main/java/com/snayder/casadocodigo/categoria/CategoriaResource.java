package com.snayder.casadocodigo.categoria;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("categorias")
//3 pontos de entendimento
public class CategoriaResource {
    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public CategoriaResponse salvar(@RequestBody @Valid CategoriaRequest request) {
        Categoria novaCategoria = manager.merge(new Categoria(request.getNome()));
        return new CategoriaResponse(novaCategoria);
    }
}
