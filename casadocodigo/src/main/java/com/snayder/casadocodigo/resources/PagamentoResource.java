package com.snayder.casadocodigo.resources;

import com.snayder.casadocodigo.domain.Carrinho;
import com.snayder.casadocodigo.domain.Pagamento;
import com.snayder.casadocodigo.domain.dtos.request.PagamentoRequest;
import com.snayder.casadocodigo.domain.dtos.response.PagamentoResponse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public PagamentoResponse salvar(@RequestBody @Valid PagamentoRequest request) {
        Pagamento pagamento = request.toModel(manager);
        manager.persist(pagamento);
        return new PagamentoResponse(pagamento);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PagamentoResponse> buscarPagamentos() {
        List<Pagamento> pagamentos = manager.createQuery(JPQL_BUSCAR_PAGAMENTOS, Pagamento.class).getResultList();
        return pagamentos.stream().map(PagamentoResponse :: new).toList();
    }
}
