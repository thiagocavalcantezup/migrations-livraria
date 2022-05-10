package br.com.zup.handora.migrationslivraria.livro;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.hibernate.validator.constraints.ISBN;
import org.hibernate.validator.constraints.ISBN.Type;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import br.com.zup.handora.migrationslivraria.autor.Autor;
import br.com.zup.handora.migrationslivraria.autor.AutorRepository;

public class LivroRequest {

    @NotBlank
    private String titulo;

    @NotNull
    @PositiveOrZero
    private BigDecimal valor;

    @NotNull
    @Positive
    private Integer numeroPaginas;

    @NotBlank
    @ISBN(type = Type.ANY)
    private String isbn;

    @NotNull
    @PastOrPresent
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataPublicacao;

    @NotNull
    private Long autorId;

    @NotNull
    @Enumerated(EnumType.STRING)
    private StatusLivro status;

    public LivroRequest() {}

    public LivroRequest(@NotBlank String titulo, @NotNull @PositiveOrZero BigDecimal valor,
                        @NotNull @Positive Integer numeroPaginas,
                        @NotBlank @ISBN(type = Type.ANY) String isbn,
                        @NotNull @PastOrPresent LocalDate dataPublicacao, @NotNull Long autorId,
                        @NotNull StatusLivro status) {
        this.titulo = titulo;
        this.valor = valor;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.autorId = autorId;
        this.status = status;
    }

    public Livro toModel(AutorRepository autorRepository) {
        Autor autor = autorRepository.findById(autorId)
                                     .orElseThrow(
                                         () -> new ResponseStatusException(
                                             HttpStatus.NOT_FOUND,
                                             "Não existe um autor com o id fornecido."
                                         )
                                     );

        return new Livro(titulo, valor, numeroPaginas, isbn, dataPublicacao, autor, status);
    }

    public String getTitulo() {
        return titulo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public Long getAutorId() {
        return autorId;
    }

    public StatusLivro getStatus() {
        return status;
    }

}
