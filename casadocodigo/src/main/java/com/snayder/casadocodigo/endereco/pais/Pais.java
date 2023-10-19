package com.snayder.casadocodigo.endereco.pais;

import com.snayder.casadocodigo.endereco.estado.Estado;
import com.snayder.casadocodigo.exceptions.OperacaoInvalidaException;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_pais")
public class Pais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nome;

    @OneToMany(mappedBy = "pais")
    private final List<Estado> estados = new ArrayList<>();

    public Long getId() {
        return id;
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

    public List<Estado> getEstados() {
        return estados;
    }

    @Override
    public String toString() {
        return "Pais{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", estados=" + estados +
                '}';
    }

    public Estado obterEstado(Long estadoId) {
        return estados.stream()
                .filter(estado -> estado.getId() == estadoId)
                .findFirst()
                .orElseThrow(() -> new OperacaoInvalidaException("Você deve informar um estado válido para o páis de id " + id + "."));
    }
}
