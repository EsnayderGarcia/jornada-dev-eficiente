package com.snayder.casadocodigo.domain.dtos.request;

import com.snayder.casadocodigo.annotations.ExistId;
import com.snayder.casadocodigo.domain.Endereco;
import com.snayder.casadocodigo.domain.Estado;
import com.snayder.casadocodigo.domain.Pagamento;
import com.snayder.casadocodigo.domain.Pais;
import jakarta.persistence.EntityManager;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

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

    public PagamentoRequest(String nome, String sobrenome, String email, String documento, Endereco endereco, Long paisId, Long estadoId) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.documento = documento;
        this.endereco = endereco;
        this.paisId = paisId;
        this.estadoId = estadoId;
    }

    public Pagamento toModel(EntityManager manager) {
        Pais pais = manager.find(Pais.class, paisId);
        Estado estado = manager.find(Estado.class, estadoId);

        return new Pagamento(nome, sobrenome, email, documento, endereco, pais, estado);
    }
}



