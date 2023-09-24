package com.snayder.casadocodigo.domain;

import com.snayder.casadocodigo.domain.dtos.request.CarrinhoRequest;
import com.snayder.casadocodigo.exceptions.OperacaoInvalidaException;
import jakarta.persistence.*;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Entity
@Table(name = "tb_pagamento")
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String sobrenome;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String documento;

    @Embedded
    private Endereco endereco;

    /*
    * Aqui salvamos o valor original da compra, caso ela seja feita com cupom de desconto.
    */
    private BigDecimal totalOriginal;

    private BigDecimal total;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "carrinho_id")
    private Carrinho carrinho;

    @OneToOne
    @JoinColumn(name = "cupom_id")
    private Cupom cupom;

    @ManyToOne
    @JoinColumn(name = "paisId", nullable = false)
    private Pais pais;

    @ManyToOne
    @JoinColumn(name = "estadoId")
    private Estado estado;

    public Pagamento() {
    }

    public Pagamento(String nome, String sobrenome, String email, String documento, Endereco endereco, Pais pais) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.documento = documento;
        this.endereco = endereco;
        this.pais = pais;
    }

    public Long getId() {
        return id;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Cupom getCupom() {
        return cupom;
    }

    public void setCupom(Cupom cupom) {
        this.cupom = cupom;
    }

    public BigDecimal getTotalOriginal() {
        return totalOriginal;
    }

    public void setTotalOriginal(BigDecimal totalOriginal) {
        this.totalOriginal = totalOriginal;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Transactional(readOnly = true)
    public void carregarValorCompra(CarrinhoRequest carrinho, EntityManager manager) {
        if (carrinho.valorTotalEhValido(manager)) {
            BigDecimal totalCarrinho = carrinho.getTotal().setScale(2, RoundingMode.HALF_EVEN);
            totalOriginal = totalCarrinho;
            total = totalCarrinho;

            this.carrinho = carrinho.toModel(manager);
        }
        else {
            throw new OperacaoInvalidaException("O valor total calculado no sistema não é o mesmo informado.");
        }
    }

    @Transactional(readOnly = true)
    public void aplicarCupom(String codigoCupom, EntityManager manager) {
        cupom = manager.find(Cupom.class, codigoCupom);

        BigDecimal desconto = (total.multiply(cupom.getDesconto())).divide(new BigDecimal("100"));
        BigDecimal totalComDesconto = total.subtract(desconto);

        total = totalComDesconto.setScale(2, RoundingMode.HALF_EVEN);
    }
}



