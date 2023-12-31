package com.snayder.casadocodigo.validators;

import com.snayder.casadocodigo.cupom.Cupom;
import com.snayder.casadocodigo.cupom.CupomRepository;
import com.snayder.casadocodigo.pagamento.PagamentoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class CupomValidator implements Validator {
    @Autowired
    private CupomRepository cupomRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return PagamentoRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        PagamentoRequest pagamentoRequest = (PagamentoRequest) target;
        String codigoCupom = pagamentoRequest.getCupom();

        if (!StringUtils.hasText(codigoCupom))
            return;

        Optional<Cupom> possivelCupom = cupomRepository.findById(codigoCupom);

        if (possivelCupom.isEmpty()) {
            errors.rejectValue("cupom", null, "Cupom de código " + codigoCupom + " não foi encontrado.");
            return;
        }

        Cupom cupom = possivelCupom.get();

        if (cupom.temDataValidadeVencida()) {
            errors.rejectValue("cupom", null, "Cupom de código " + codigoCupom + " está com a data de validade vencida.");
        }
    }
}
