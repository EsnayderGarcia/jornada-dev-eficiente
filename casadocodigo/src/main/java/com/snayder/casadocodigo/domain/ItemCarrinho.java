package com.snayder.casadocodigo.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "tb_item_carrinho")
public class ItemCarrinho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "livro_id")
    private Livro Livro;

    @ManyToOne
    @JoinColumn(name = "carrinho_id")
    private Carrinho carrinho;

    private Integer quantidade;

    public ItemCarrinho() {
    }

    public ItemCarrinho(com.snayder.casadocodigo.domain.Livro livro, Carrinho carrinho, Integer quantidade) {
        Livro = livro;
        this.carrinho = carrinho;
        this.quantidade = quantidade;
    }

    public Livro getLivro() {
        return Livro;
    }

    public void setLivro(Livro livro) {
        Livro = livro;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
