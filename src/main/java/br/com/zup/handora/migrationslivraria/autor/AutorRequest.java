package br.com.zup.handora.migrationslivraria.autor;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AutorRequest {

    @NotEmpty
    @Size(max = 120)
    private String nome;

    @NotEmpty
    @Size(max = 120)
    @Email
    private String email;

    @NotNull
    @PastOrPresent
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    @NotEmpty
    @Size(max = 300)
    private String biografia;

    public AutorRequest() {}

    public AutorRequest(@NotEmpty @Size(max = 120) String nome,
                        @NotEmpty @Size(max = 120) @Email String email,
                        @NotNull @PastOrPresent LocalDate dataNascimento,
                        @NotEmpty @Size(max = 300) String biografia) {
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.biografia = biografia;
    }

    public Autor toModel() {
        return new Autor(nome, email, dataNascimento, biografia);
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getBiografia() {
        return biografia;
    }

}
