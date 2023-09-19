package com.snayder.casadocodigo.domain.dtos.request;

import java.time.LocalDate;

import com.snayder.casadocodigo.annotations.UniqueValue;
import com.snayder.casadocodigo.domain.Cupom;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class CupomRequest {
	@NotBlank(message = "O campo código é obrigatório.")
//	@UniqueValue(fieldName = "codigo", message = "O codigo informado já consta no sistema.", domainClass = Cupom.class)
	private String codigo;
	
	
	@Positive(message = "O valor do desconto deve ser positivo.")
	private double desconto;
	
	@FutureOrPresent(message = "A data de validade deve ser no futuro.")
	private LocalDate validade;

	public CupomRequest(String codigo, double desconto, LocalDate validade) {
		this.codigo = codigo;
		this.desconto = desconto;
		this.validade = validade;
	} 
}
