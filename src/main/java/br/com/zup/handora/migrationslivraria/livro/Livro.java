package br.com.zup.handora.migrationslivraria.livro;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.zup.handora.migrationslivraria.autor.Autor;

@Entity
@Table(name = "livros")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private BigDecimal valor;

    @Column(nullable = false)
    private Integer numeroPaginas;

    @Column(nullable = false, length = 20)
    private String isbn;

    @Column(nullable = false)
    private LocalDate dataPublicacao;

    @ManyToOne(optional = false)
    private Autor autor;

    @Column(nullable = false)
    private LocalDateTime criadoEm = LocalDateTime.now();

    /**
     * @deprecated Construtor de uso exclusivo do Hibernate
     */
    @Deprecated
    public Livro() {}

    public Livro(String titulo, BigDecimal valor, Integer numeroPaginas, String isbn,
                 LocalDate dataPublicacao, Autor autor) {
        this.titulo = titulo;
        this.valor = valor;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.autor = autor;
    }

    public Long getId() {
        return id;
    }

}
