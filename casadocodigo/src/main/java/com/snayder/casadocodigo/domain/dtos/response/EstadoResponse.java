package com.snayder.casadocodigo.domain.dtos.response;

import com.snayder.casadocodigo.domain.Estado;

public class EstadoResponse {
    private Long id;
    private String nome;
    private Long paisId;
    private String pais;

    public EstadoResponse(Estado estado) {
        id = estado.getId();
        nome = estado.getNome();
        paisId = estado.getPais().getId();
        pais = estado.getPais().getNome();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Long getPaisId() {
        return paisId;
    }

    public String getPais() {
        return pais;
    }
}
