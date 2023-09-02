package com.snayder.casadocodigo.domain.dtos.request;

import com.snayder.casadocodigo.annotations.ExistId;
import com.snayder.casadocodigo.domain.Carrinho;
import com.snayder.casadocodigo.domain.ItemCarrinho;
import com.snayder.casadocodigo.domain.Livro;
import jakarta.persistence.EntityManager;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ItemCarrinhoRequest {
    @NotNull(message = "O campo id do livro é obrigatório.")
    @ExistId(message = "O id do livro deve existir", domainClass = Livro.class)
    private Long idLivro;

    @NotNull(message = "O campo quantidade é obrigatório.")
    @Positive(message = "A quantidade de livros deve ser maior que zero.")
    private Integer quantidade;

   public ItemCarrinhoRequest(Long idLivro, Integer quantidade) {
        this.idLivro = idLivro;
        this.quantidade = quantidade;
    }

    public double getSubTotal(EntityManager manager) {
       Livro livro = manager.find(Livro.class, idLivro);
       return quantidade * livro.getPreco().doubleValue();
    }

    @Override
    public String toString() {
        return "ItemCarrinhoRequest{" +
                "idLivro=" + idLivro +
                ", quantidade=" + quantidade +
                '}';
    }

    public ItemCarrinho toModel(EntityManager manager, Carrinho carrinho) {
        Livro livro = manager.find(Livro.class, idLivro);
       return new ItemCarrinho(livro, carrinho, quantidade);
    }
}
