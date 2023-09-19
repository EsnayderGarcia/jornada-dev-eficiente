package com.snayder.casadocodigo.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.snayder.casadocodigo.domain.dtos.request.CupomRequest;
import com.snayder.casadocodigo.domain.dtos.response.CupomResponse;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.Valid;

@RestController
@RequestMapping("cupons")
//3 pontos de entendimento
public class CupomResource {
    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    public ResponseEntity<CupomResponse> salvar(@RequestBody @Valid CupomRequest cupomRequest) {
        return null;
    }
}

 
 






