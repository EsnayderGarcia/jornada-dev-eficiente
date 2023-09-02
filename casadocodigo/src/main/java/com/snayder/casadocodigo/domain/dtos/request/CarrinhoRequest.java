package com.snayder.casadocodigo.domain.dtos.request;

import com.snayder.casadocodigo.domain.Carrinho;
import com.snayder.casadocodigo.domain.ItemCarrinho;
import com.snayder.casadocodigo.domain.Pagamento;
import jakarta.persistence.EntityManager;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoRequest {
    @NotNull(message = "O campo total é obrigatório.")
    @Positive(message = "O total deve ser um valor maior que zero.")
    private BigDecimal total;

    @Valid
    @NotEmpty(message = "O carrinho deve possuir pelo menos um item.")
    private final List<ItemCarrinhoRequest> itensCarrinho = new ArrayList<>();

    public BigDecimal getTotal() {
        return total;
    }

    public List<ItemCarrinhoRequest> getItensCarrinho() {
        return itensCarrinho;
    }

    public boolean valorTotalEhValido(EntityManager manager) {
        double soma = 0.00;
        for (ItemCarrinhoRequest item : itensCarrinho) {
            soma += item.getSubTotal(manager);
        }

        return total.doubleValue() == soma;
    }

    @Override
    public String toString() {
        return "CarrinhoRequest{" +
                "total=" + total +
                ", itensCarrinho=" + itensCarrinho +
                '}';
    }

    public Carrinho toModel(EntityManager manager) {
        Carrinho carrinho = new Carrinho(total);

        List<ItemCarrinho> itensCarrinho = this.itensCarrinho.stream()
                .map(item -> item.toModel(manager, carrinho))
                .toList();

        carrinho.getItensCarrinho().addAll(itensCarrinho);
        return carrinho;
    }
}
