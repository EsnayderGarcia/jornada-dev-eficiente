package com.snayder.casadocodigo.domain.dtos.response;

import com.snayder.casadocodigo.domain.Endereco;
import com.snayder.casadocodigo.domain.Pagamento;

import java.util.ArrayList;
import java.util.List;

public class PagamentoResponse {
    private Long id;
    private String nome;
    private String sobrenome;
    private String email;
    private String documento;
    private Endereco endereco;
    private Long paisId;
    private String pais;
    private Long estadoId;
    private String estado;
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
}



