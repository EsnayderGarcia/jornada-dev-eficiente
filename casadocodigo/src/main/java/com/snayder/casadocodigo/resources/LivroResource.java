package com.snayder.casadocodigo.resources;

import com.snayder.casadocodigo.domain.Livro;
import com.snayder.casadocodigo.domain.dtos.response.LivroMinResponse;
import com.snayder.casadocodigo.domain.dtos.request.LivroRequest;
import com.snayder.casadocodigo.domain.dtos.response.LivroDetalheResponse;
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
//5  pontos de entendimento
public class LivroResource {
    private final String JPQL_BUSCAR_LIVROS = "select l from Livro l join fetch l.categoria c join fetch l.autor a";

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
        return manager.createQuery(JPQL_BUSCAR_LIVROS, Livro.class)
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
        if (livro == null)
            throw new RecursoNaoEncontradoException("O livro de id " + id + " não encontrado.");

        return new LivroDetalheResponse(livro);
    }
}
