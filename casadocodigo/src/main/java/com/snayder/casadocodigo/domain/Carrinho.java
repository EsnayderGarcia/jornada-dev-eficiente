package com.snayder.casadocodigo.domain;

import com.snayder.casadocodigo.domain.dtos.request.CarrinhoRequest;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_carrinho")
public class Carrinho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal total;

    @OneToOne(mappedBy = "carrinho")
    private Pagamento pagamento;

    @OneToMany(mappedBy = "carrinho", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private final List<ItemCarrinho> itensCarrinho = new ArrayList<>();

    public Carrinho() {
    }

    public Carrinho(BigDecimal total) {
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<ItemCarrinho> getItensCarrinho() {
        return itensCarrinho;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }
}
