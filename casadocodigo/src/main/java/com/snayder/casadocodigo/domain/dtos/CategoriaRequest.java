package com.snayder.casadocodigo.domain.dtos;

import com.snayder.casadocodigo.annotations.UniqueValue;
import com.snayder.casadocodigo.domain.Categoria;
import jakarta.validation.constraints.NotBlank;

public class CategoriaRequest {
    @NotBlank(message = "O campo nome é obrigatório.")
    @UniqueValue(fieldName = "nome", message = "O nome informado já consta no sistema.", domainClass = Categoria.class)
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
