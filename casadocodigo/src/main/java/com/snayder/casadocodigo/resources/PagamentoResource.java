package com.snayder.casadocodigo.resources;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.snayder.casadocodigo.domain.Pagamento;
import com.snayder.casadocodigo.domain.dtos.request.PagamentoRequest;
import com.snayder.casadocodigo.domain.dtos.response.PagamentoResponse;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.Valid;

@RestController
@RequestMapping("pagamentos")
//3 pontos de entendimento
public class PagamentoResource {
    @PersistenceContext
    private EntityManager manager;
    private static final String JPQL_BUSCAR_PAGAMENTOS = "select p from Pagamento p";

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public ResponseEntity<PagamentoResponse> salvar(@RequestBody @Valid PagamentoRequest request) {
        Pagamento pagamento = request.toModel(manager);
        manager.persist(pagamento);
        return ResponseEntity.ok(new PagamentoResponse(pagamento));
    }
 
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<PagamentoResponse>> buscarPagamentos() {
        List<Pagamento> pagamentos = manager.createQuery(JPQL_BUSCAR_PAGAMENTOS, Pagamento.class).getResultList();
        return ResponseEntity.ok(pagamentos.stream().map(PagamentoResponse :: new).toList());
    }
} 
