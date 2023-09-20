package com.snayder.casadocodigo.domain.dtos.response;

import com.snayder.casadocodigo.domain.Cupom;

import java.time.LocalDate;

public class CupomResponse {
    private final String codigo;
    private final double desconto;
    private final LocalDate validade;


    public CupomResponse(Cupom cupom) {
        codigo = cupom.getCodigo();
        desconto = cupom.getDesconto();
        validade = cupom.getValidade();
    }

    public String getCodigo() {
        return codigo;
    }

    public double getDesconto() {
        return desconto;
    }

    public LocalDate getValidade() {
        return validade;
    }
}
