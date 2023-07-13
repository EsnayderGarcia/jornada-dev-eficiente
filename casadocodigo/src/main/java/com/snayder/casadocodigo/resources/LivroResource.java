package com.snayder.casadocodigo.resources;

import com.snayder.casadocodigo.domain.Livro;
import com.snayder.casadocodigo.domain.dtos.LivroRequest;
import com.snayder.casadocodigo.domain.dtos.LivroResponse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("livros")
//3 pontos de entendimento
public class LivroResource {
    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public LivroResponse salvar(@RequestBody @Valid LivroRequest request) {
        Livro novoLivro = manager.merge(request.toModel());
        return new LivroResponse(novoLivro);
    }
}
