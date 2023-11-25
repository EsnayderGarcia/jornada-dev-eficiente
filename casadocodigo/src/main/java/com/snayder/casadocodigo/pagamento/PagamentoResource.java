package com.snayder.casadocodigo.pagamento;

import com.snayder.casadocodigo.endereco.estado.PreenchimentoEstadoValidator;
import com.snayder.casadocodigo.validators.CupomValidator;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pagamentos")
//3 pontos de entendimento
public class PagamentoResource {
    private static final String JPQL_BUSCAR_PAGAMENTOS = "select p from Pagamento p";

    @PersistenceContext
    private EntityManager manager;

    private final CupomValidator cupomValidator;
    private final PreenchimentoEstadoValidator preenchimentoEstadoValidator;

    public PagamentoResource(CupomValidator cupomValidator, PreenchimentoEstadoValidator preenchimentoEstadoValidator) {
        this.cupomValidator = cupomValidator;
        this.preenchimentoEstadoValidator = preenchimentoEstadoValidator;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(cupomValidator, preenchimentoEstadoValidator);
    }

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
