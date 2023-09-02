package com.snayder.casadocodigo.domain.dtos.response;

import com.snayder.casadocodigo.domain.Livro;

public class LivroCompradoResponse extends LivroMinResponse{

    private final double preco;
    private final String categoria;
    private final String isbn;

    public LivroCompradoResponse(Livro livro) {
        super(livro);
        preco = livro.getPreco().doubleValue();
        categoria = livro.getCategoria().getNome();
        isbn = livro.getIsbn();
    }

    public double getPreco() {
        return preco;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getIsbn() {
        return isbn;
    }
}
