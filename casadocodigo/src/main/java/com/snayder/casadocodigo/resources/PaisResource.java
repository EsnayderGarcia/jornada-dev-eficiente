package com.snayder.casadocodigo.resources;

import com.snayder.casadocodigo.domain.Pais;
import com.snayder.casadocodigo.domain.dtos.request.PaisRequest;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pais")
//3 pontos de entendimento
public class PaisResource {
    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public String salvar(@RequestBody @Valid PaisRequest request) {
        Pais pais = new Pais();
        pais.setNome(request.getNome());

        return manager.merge(pais).toString();
    }
}
