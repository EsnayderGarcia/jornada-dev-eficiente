package com.snayder.casadocodigo.domain;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Embeddable
public class Endereco {
    @NotBlank(message = "O campo cep é obrigatório.")
    private String cep;

    @NotBlank(message = "O campo cidade é obrigatório.")
    private String cidade;

    @NotBlank(message = "O campo bairro é obrigatório.")
    private String bairro;

    @NotBlank(message = "O campo rua é obrigatório.")
    private String rua;

    @NotNull(message = "O campo número é obrigatório.")
    private Integer numero;

    @NotBlank(message = "O campo complemento é obrigatório.")
    private String complemento;

    @NotBlank(message = "O campo telefone é obrigatório.")
    private String telefone;

    public Endereco(String cep, String cidade, String bairro, String rua, Integer numero, String complemento, String telefone) {
        this.cep = cep;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.telefone = telefone;
    }
}
