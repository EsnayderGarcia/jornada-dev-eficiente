package com.snayder.casadocodigo.carrinho;

import com.snayder.casadocodigo.livro.Livro;
import com.snayder.casadocodigo.livro.LivroCompradoResponse;

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
