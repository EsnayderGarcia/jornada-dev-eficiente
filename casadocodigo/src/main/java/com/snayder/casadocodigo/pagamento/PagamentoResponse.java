package com.snayder.casadocodigo.pagamento;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.snayder.casadocodigo.carrinho.CarrinhoResponse;
import com.snayder.casadocodigo.endereco.Endereco;

import java.math.BigDecimal;

public class PagamentoResponse {
    private Long id;
    private String nome;
    private String sobrenome;
    private String email;
    private String documento;
    private Endereco endereco;
    private Long paisId;
    private String pais;

    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private Long estadoId;

    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String estado;

    private BigDecimal totalOriginal;
    private BigDecimal total;

    private CarrinhoResponse carrinho;

    public PagamentoResponse(Pagamento pagamento) {
        id = pagamento.getId();
        nome = pagamento.getNome();
        sobrenome = pagamento.getSobrenome();
        email = pagamento.getEmail();
        documento = pagamento.getDocumento();
        endereco = pagamento.getEndereco();
        paisId = pagamento.getPais().getId();
        pais = pagamento.getPais().getNome();
        estadoId = pagamento.getEstado() == null ? null : pagamento.getEstado().getId();
        estado = pagamento.getEstado() == null ? null : pagamento.getEstado().getNome();
        total = pagamento.getTotal();
        totalOriginal = pagamento.getTotalOriginal();
        carrinho = new CarrinhoResponse(pagamento.getCarrinho());
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public String getDocumento() {
        return documento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public Long getPaisId() {
        return paisId;
    }

    public String getPais() {
        return pais;
    }

    public Long getEstadoId() {
        return estadoId;
    }

    public String getEstado() {
        return estado;
    }

    public CarrinhoResponse getCarrinho() {
        return carrinho;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public BigDecimal getTotalOriginal() {
        return totalOriginal;
    }
}



