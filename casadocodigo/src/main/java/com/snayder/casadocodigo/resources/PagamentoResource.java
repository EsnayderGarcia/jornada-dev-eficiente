package com.snayder.casadocodigo.resources;

import com.snayder.casadocodigo.domain.Pagamento;
import com.snayder.casadocodigo.domain.dtos.request.PagamentoRequest;
import com.snayder.casadocodigo.domain.dtos.response.PagamentoResponse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pagamentos")
//3 pontos de entendimento
public class PagamentoResource {
    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public PagamentoResponse salvar(@RequestBody @Valid PagamentoRequest request) {
        Pagamento pagamento = request.toModel(manager);
        return new PagamentoResponse(pagamento);
    }
}
