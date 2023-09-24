package com.snayder.casadocodigo.domain.dtos.response;

import com.snayder.casadocodigo.domain.Cupom;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CupomResponse {
    private final String codigo;
    private final BigDecimal desconto;
    private final LocalDate validade;


    public CupomResponse(Cupom cupom) {
        codigo = cupom.getCodigo();
        desconto = cupom.getDesconto();
        validade = cupom.getValidade();
    }

    public String getCodigo() {
        return codigo;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public LocalDate getValidade() {
        return validade;
    }
}
