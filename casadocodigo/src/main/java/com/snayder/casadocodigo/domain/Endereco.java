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

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
