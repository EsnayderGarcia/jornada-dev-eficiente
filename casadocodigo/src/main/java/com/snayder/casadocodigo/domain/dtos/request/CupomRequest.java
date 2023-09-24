package com.snayder.casadocodigo.domain.dtos.request;

import com.snayder.casadocodigo.annotations.UniqueValue;
import com.snayder.casadocodigo.domain.Cupom;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CupomRequest {
	@NotBlank(message = "O campo código é obrigatório.")
	@UniqueValue(fieldName = "codigo", message = "O codigo informado já consta no sistema.", domainClass = Cupom.class)
	private String codigo;

	@Positive(message = "O valor do desconto deve ser positivo.")
	@Max(value = 20, message = "A porcetagem máxima de desconto é {value}.")
	private BigDecimal desconto;

	@NotNull(message = "O campo validade é obrigatório.")
	@Future(message = "A data de validade deve ser no futuro.")
	private LocalDate validade;

	public CupomRequest(String codigo, BigDecimal desconto, LocalDate validade) {
		this.codigo = codigo;
		this.desconto = desconto;
		this.validade = validade;
	}

	public Cupom toModel() {
		return new Cupom(codigo, desconto, validade);
	}
}
