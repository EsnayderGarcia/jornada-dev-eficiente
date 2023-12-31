package com.snayder.casadocodigo.endereco.estado;

import com.snayder.casadocodigo.endereco.pais.Pais;
import jakarta.persistence.*;
import org.springframework.validation.Errors;

@Entity
@Table(name = "tb_estado")
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String nome;

    @ManyToOne()
    @JoinColumn(name = "pais_id", nullable = false)
    private Pais pais;

    public Estado(String nome, Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }

    public Estado() {
    }

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

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Estado{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", pais=" + pais +
                '}';
    }

    public void validarEstadoPertenceAoPais(Pais pais, Errors errors) {
        if(!this.pais.getNome().equalsIgnoreCase(pais.getNome()))
            errors.rejectValue("estadoId", null, "O estado informado não pertence ao país associado a este pagamento.");
    }
}
