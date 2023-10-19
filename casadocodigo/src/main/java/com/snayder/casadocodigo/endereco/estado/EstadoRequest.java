package com.snayder.casadocodigo.endereco.estado;

import com.snayder.casadocodigo.annotations.ExistId;
import com.snayder.casadocodigo.annotations.UniqueValue;
import com.snayder.casadocodigo.endereco.pais.Pais;
import jakarta.persistence.EntityManager;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EstadoRequest {
    @NotBlank(message = "O campo nome é obrigatório.")
    @UniqueValue(fieldName = "nome", message = "O nome do estado informado já consta no sistema.", domainClass = Estado.class)
    private String nome;

    @NotNull(message = "O campo id do país é obrigatório.")
    @ExistId(message = "O id do país deve existir", domainClass = Pais.class)
    private Long paisId;

    public EstadoRequest(String nome, Long paisId) {
        this.nome = nome;
        this.paisId = paisId;
    }

    public Estado toModel(EntityManager manager) {
        Pais pais = manager.find(Pais.class, paisId);
        return new Estado(nome, pais);
    }
}
