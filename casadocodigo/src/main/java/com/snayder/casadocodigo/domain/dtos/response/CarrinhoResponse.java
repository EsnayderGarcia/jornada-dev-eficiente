package com.snayder.casadocodigo.domain.dtos.response;

import com.snayder.casadocodigo.domain.Carrinho;
import com.snayder.casadocodigo.domain.ItemCarrinho;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoResponse {
    private final List<ItemResponse> itens = new ArrayList<>();

    public CarrinhoResponse(Carrinho carrinho) {
        List<ItemCarrinho> itensCarrinho = carrinho.getItensCarrinho();
        itensCarrinho.forEach(item -> this.itens.add(new ItemResponse(item.getLivro(), item.getQuantidade())));
    }

    public List<ItemResponse> getItens() {
        return itens;
    }
}
