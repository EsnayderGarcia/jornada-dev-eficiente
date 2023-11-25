package com.snayder.casadocodigo.endereco.estado;


import com.snayder.casadocodigo.endereco.pais.PaisRepository;
import com.snayder.casadocodigo.pagamento.PagamentoRequest;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Objects;

@Component
public class PreenchimentoEstadoValidator implements Validator {
    private final PaisRepository paisRepository;
    private final EstadoRepository estadoRepository;

    public PreenchimentoEstadoValidator(PaisRepository paisRepository, EstadoRepository estadoRepository) {
        this.paisRepository = paisRepository;
        this.estadoRepository = estadoRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return PagamentoRequest.class.isAssignableFrom(clazz);
    }

    @Transactional(readOnly = true)
    @Override
    public void validate(Object target, Errors errors) {
        PagamentoRequest pagamento = (PagamentoRequest) target;

        paisRepository.findById(pagamento.getPaisId()).ifPresent(pais -> {
            if (!pais.getEstados().isEmpty() && Objects.isNull(pagamento.getEstadoId())) {
                errors.rejectValue("estadoId", null, "O estado é obrigatório para este pagamento.");
                return;
            }

            estadoRepository.findById(pagamento.getEstadoId()).ifPresentOrElse(estado -> estado.validarEstadoPertenceAoPais(pais, errors),
                    () -> errors.rejectValue("estadoId", null, "O estado informado não existe."));
        });
    }
}
