package com.snayder.casadocodigo.domain.dtos;

import com.snayder.casadocodigo.annotations.ExistId;
import com.snayder.casadocodigo.annotations.UniqueValue;
import com.snayder.casadocodigo.domain.Autor;
import com.snayder.casadocodigo.domain.Categoria;
import com.snayder.casadocodigo.domain.Livro;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroRequest {
    @NotBlank(message = "O campo título é obrigatório.")
    @UniqueValue(fieldName = "titulo", message = "O titulo informado já consta no sistema.", domainClass = Livro.class)
    private String titulo;

    @NotBlank(message = "O campo resumo é obrigatório.")
    @Size(max = 500, message = "O campo resumo deve ter no máximo {max} caracteres")
    private String resumo;

    private String sumario;

    @NotNull(message = "O campo preço é obrigatório.")
    @Min(value = 20, message = "O preço deve ser a partir de {value} reais")
    private BigDecimal preco;

    @NotNull(message = "O campo paginas é obrigatório.")
    @Min(value = 100, message = "O livro deve conter no minímo {value} páginas.")
    private Integer paginas;

    @NotBlank(message = "O campo ISBN é obrigatório.")
    @UniqueValue(fieldName = "isbn", message = "O isbn informado já consta no sistema.", domainClass = Livro.class)
    private String isbn;

    @NotNull(message = "O campo data de publicação é obrigatório.")
    @Future(message = "A data de publicação deve ser posterior a data atual.")
    private LocalDate dataPublicacao;

    @NotNull(message = "O campo categoria é obrigatório.")
    @ExistId(message = "O id da categoria deve existir", domainClass = Categoria.class)
    private Long categoriaId;

    @NotNull(message = "O campo autor é obrigatório.")
    @ExistId(message = "O id do autor deve existir", domainClass = Autor.class)
    private Long autorId;

    public LivroRequest(String titulo, String resumo, String sumario, BigDecimal preco, Integer paginas, String isbn, LocalDate dataPublicacao, Long categoriaId, Long autorId) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.paginas = paginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.categoriaId = categoriaId;
        this.autorId = autorId;
    }

    public Livro toModel() {
        return new Livro(titulo, resumo, sumario, preco, paginas, isbn, dataPublicacao, new Categoria(categoriaId), new Autor(autorId));
    }
}
