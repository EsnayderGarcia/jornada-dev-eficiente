package com.snayder.casadocodigo.autor;

import com.snayder.casadocodigo.annotations.UniqueValue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AutorRequest {

    @NotBlank(message = "O campo nome é obrigatório.")
    private String nome;

    @NotBlank(message = "O campo email é obrigatório.")
    @Email(message = "O email deve ser válido.")
    @UniqueValue(fieldName = "email", message = "O email informado já consta no sistema.", domainClass = Autor.class)
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

    public String getEmail() {
        return email;
    }
}
