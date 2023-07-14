package com.snayder.casadocodigo.domain.dtos;

import com.snayder.casadocodigo.domain.Livro;

public class LivroMinResponse {
    private Long id;
    private String titulo;

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
