package com.snayder.casadocodigo.domain.dtos.request;

import com.snayder.casadocodigo.domain.Estado;
import com.snayder.casadocodigo.domain.Pagamento;
import com.snayder.casadocodigo.domain.Pais;
import jakarta.persistence.EntityManager;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

public class PagamentoRequest {
    private String nome;
    private String sobrenome;
    private String email;
    @CPF
    @CNPJ
    private String documento;
    private String complemento;
    private String endereco;
    private String cidade;
    private Long paisId;
    private Long estadoId;
    private String telefone;
    private String cep;

    public PagamentoRequest(String nome, String sobrenome, String email, String documento, String complemento, String endereco, String cidade, Long paisId, Long estadoId, String telefone, String cep) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.documento = documento;
        this.complemento = complemento;
        this.endereco = endereco;
        this.cidade = cidade;
        this.paisId = paisId;
        this.estadoId = estadoId;
        this.telefone = telefone;
        this.cep = cep;
    }

    public Pagamento toModel(EntityManager manager) {
        Pais pais = manager.find(Pais.class, paisId);
        Estado estado = manager.find(Estado.class, estadoId);

        return new Pagamento(nome, sobrenome, email, documento, complemento, endereco, cidade, pais, estado, telefone, cep);
    }
}



