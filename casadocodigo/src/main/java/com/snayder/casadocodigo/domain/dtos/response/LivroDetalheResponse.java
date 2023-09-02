package com.snayder.casadocodigo.domain.dtos.response;

import com.snayder.casadocodigo.domain.Livro;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroDetalheResponse {
    private final Long id;
    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private Integer paginas;
    private String isbn;
    private LocalDate dataPublicacao;
    private Long categoriaId;
    private String categoria;
    private Long autorId;
    private String autor;

    public LivroDetalheResponse(Livro livro) {
        id = livro.getId();
        titulo = livro.getTitulo();
        resumo = livro.getResumo();
        sumario = livro.getSumario();
        preco = livro.getPreco();
        paginas = livro.getPaginas();
        isbn = livro.getIsbn();
        dataPublicacao = livro.getDataPublicacao();
        categoriaId = livro.getCategoria().getId();
        categoria = livro.getCategoria().getNome();
        autorId = livro.getAutor().getId();
        autor = livro.getAutor().getNome();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public String getCategoria() {
        return categoria;
    }

    public Long getAutorId() {
        return autorId;
    }

    public String getAutor() {
        return autor;
    }
}
