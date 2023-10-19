package com.snayder.casadocodigo.autor;

import java.time.LocalDateTime;

public class AutorResponse {
    private Long id;

    private String nome;

    private String email;

    private String descricao;

    private LocalDateTime instanteCriacao;

    public AutorResponse(Autor autor) {
        id = autor.getId();
        nome = autor.getNome();
        email = autor.getEmail();
        descricao = autor.getDescricao();
        instanteCriacao = autor.getInstanteCriacao();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getInstanteCriacao() {
        return instanteCriacao;
    }
}
