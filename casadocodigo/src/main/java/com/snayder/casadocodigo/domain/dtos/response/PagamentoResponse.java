package com.snayder.casadocodigo.domain.dtos.response;

import com.snayder.casadocodigo.domain.Pagamento;

public class PagamentoResponse {
    private Long id;
    private String nome;
    private String sobrenome;
    private String email;
    private String documento;
    private String complemento;
    private String endereco;
    private String cidade;
    private Long paisId;
    private String pais;
    private Long estadoId;
    private String estado;
    private String telefone;
    private String cep;

    public PagamentoResponse(Pagamento pagamento) {
        id = pagamento.getId();
        nome = pagamento.getNome();
        sobrenome = pagamento.getSobrenome();
        email = pagamento.getEmail();
        documento = pagamento.getDocumento();
        complemento = pagamento.getComplemento();
        endereco = pagamento.getEndereco();
        cidade = pagamento.getCidade();
        paisId = pagamento.getPais().getId();
        pais = pagamento.getPais().getNome();
        estadoId = pagamento.getEstado().getId();
        estado = pagamento.getEstado().getNome();
        telefone = pagamento.getTelefone();
        cep = pagamento.getCep();
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

    public String getComplemento() {
        return complemento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getCidade() {
        return cidade;
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

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }
}



