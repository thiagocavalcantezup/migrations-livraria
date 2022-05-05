package br.com.zup.handora.migrationslivraria.autor;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "autores")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String nome;

    @Column(nullable = false, length = 120)
    private String email;

    @Column(nullable = false)
    private LocalDate dataNascimento;

    @Column(nullable = false, length = 300)
    private String biografia;

    @Column(nullable = false)
    private LocalDateTime dataCriacao = LocalDateTime.now();

    /**
     * @deprecated Construtor de uso exclusivo do Hibernate
     */
    @Deprecated
    public Autor() {}

    public Autor(String nome, String email, LocalDate dataNascimento, String biografia) {
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.biografia = biografia;
    }

    public Long getId() {
        return id;
    }

}
