package com.snayder.casadocodigo.domain.dtos.response;

import com.snayder.casadocodigo.domain.Livro;

public class LivroMinResponse {
    private final Long id;
    private final String titulo;

    public LivroMinResponse(Livro livro) {
        id = livro.getId();
        titulo = livro.getTitulo();
    }

    public Long getId() {
        return id;
    }
    public String getTitulo() {
        return titulo;
    }
}
