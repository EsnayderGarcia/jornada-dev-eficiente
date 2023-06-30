package com.snayder.casadocodigo.domain.dtos;

import com.snayder.casadocodigo.domain.Autor;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AutorRequest {

    @NotBlank(message = "O campo nome é obrigatório.")
    private String nome;

    @NotBlank(message = "O campo email é obrigatório.")
    @Email(message = "O email deve ser válido.")
    private String email;

    @NotBlank(message = "O campo descrição é obrigatório.")
    @Size(max = 400)
    private String descricao;

    public AutorRequest(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Autor toModel() {
        return new Autor(nome, email, descricao);
    }
}
