package com.snayder.casadocodigo.endereco.pais;

import com.snayder.casadocodigo.annotations.UniqueValue;
import jakarta.validation.constraints.NotBlank;

public class PaisRequest {
    @NotBlank(message = "O campo nome é obrigatório.")
    @UniqueValue(fieldName = "nome", message = "O nome do país informado já consta no sistema.", domainClass = Pais.class)
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
