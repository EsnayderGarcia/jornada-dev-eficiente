package com.snayder.casadocodigo.resources;

import com.snayder.casadocodigo.domain.Livro;
import com.snayder.casadocodigo.domain.dtos.LivroMinResponse;
import com.snayder.casadocodigo.domain.dtos.LivroRequest;
import com.snayder.casadocodigo.domain.dtos.LivroDetalheResponse;
import com.snayder.casadocodigo.exceptions.RecursoNaoEncontradoException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("livros")
//4 pontos de entendimento
public class LivroResource {
    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public LivroMinResponse salvar(@RequestBody @Valid LivroRequest request) {
        Livro novoLivro = manager.merge(request.toModel());
        return new LivroMinResponse(novoLivro);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Transactional(readOnly = true)
    public List<LivroMinResponse> buscar() {
        return manager.createQuery("SELECT obj FROM Livro obj", Livro.class)
                .getResultList()
                .stream()
                .map(LivroMinResponse::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Transactional(readOnly = true)
    public LivroDetalheResponse buscarPorId(@PathVariable Long id) {
        Livro livro = manager.find(Livro.class, id);
        if(livro == null)
            throw new RecursoNaoEncontradoException("O livro de id "+id+ " não encontrado.");

        return new LivroDetalheResponse(livro);
    }
}
