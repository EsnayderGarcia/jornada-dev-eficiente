package com.snayder.casadocodigo.domain.dtos.response;

import com.snayder.casadocodigo.domain.Livro;

public class ItemResponse {
    private LivroCompradoResponse livro;
    private int quantidade;

    public ItemResponse(Livro livro, int quantidade) {
        this.livro = new LivroCompradoResponse(livro);
        this.quantidade = quantidade;
    }

    public LivroCompradoResponse getLivro() {
        return livro;
    }

    public int getQuantidade() {
        return quantidade;
    }
}
