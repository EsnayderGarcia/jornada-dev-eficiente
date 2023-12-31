package com.snayder.casadocodigo.pagamento;

import com.snayder.casadocodigo.annotations.ExistId;
import com.snayder.casadocodigo.carrinho.CarrinhoRequest;
import com.snayder.casadocodigo.endereco.Endereco;
import com.snayder.casadocodigo.endereco.estado.Estado;
import com.snayder.casadocodigo.endereco.pais.Pais;
import jakarta.persistence.EntityManager;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

public class PagamentoRequest {
    @NotBlank(message = "O campo nome é obrigatório.")
    private String nome;

    @NotBlank(message = "O campo sobrenome é obrigatório.")
    private String sobrenome;

    @NotBlank(message = "O campo email é obrigatório.")
    @Email(message = "Informe um email válido")
    private String email;

    @NotBlank(message = "O campo documento(CPF/CNPJ) é obrigatório.")
    private String documento;

    @Valid
    @NotNull(message = "O campo é endereço é obrigatório")
    private Endereco endereco;

    @NotNull(message = "O campo id do país é obrigatório.")
    @ExistId(message = "O id do país deve existir", domainClass = Pais.class)
    private Long paisId;
    private Long estadoId;

    private String cupom;

    @Valid
    @NotNull(message = "É necessário associar um carrinho a este pagamento.")
    private CarrinhoRequest carrinho;

    public PagamentoRequest(String nome, String sobrenome, String email, String documento, Endereco endereco, Long paisId, Long estadoId, String cupom, CarrinhoRequest carrinho) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.documento = documento;
        this.endereco = endereco;
        this.paisId = paisId;
        this.estadoId = estadoId;
        this.cupom = cupom;
        this.carrinho = carrinho;
    }

    @Transactional(readOnly = true)
    public Pagamento toModel(EntityManager manager) {
        Pais pais = manager.find(Pais.class, paisId);
        Pagamento pagamento = new Pagamento(nome, sobrenome, email, documento, endereco, pais);

        if ( estadoId != null) {
            pagamento.setEstado(manager.find(Estado.class, estadoId));
        }

        pagamento.carregarValorCompra(carrinho, manager);

        if (StringUtils.hasText(cupom)) {
            pagamento.aplicarCupom(cupom, manager);
        }

        return pagamento;
    }

    public String getCupom() {
        return cupom;
    }

    public Long getPaisId() {
        return paisId;
    }

    public Long getEstadoId() {
        return estadoId;
    }
}



