package br.com.zup.handora.migrationslivraria.livro;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.handora.migrationslivraria.autor.AutorRepository;

@RestController
@RequestMapping(LivroController.BASE_URI)
public class LivroController {

    public final static String BASE_URI = "/livros";

    private final LivroRepository livroRepository;
    private final AutorRepository autorRepository;

    public LivroController(LivroRepository livroRepository, AutorRepository autorRepository) {
        this.livroRepository = livroRepository;
        this.autorRepository = autorRepository;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid LivroRequest livroRequest,
                                    UriComponentsBuilder ucb) {
        Livro livro = livroRepository.save(livroRequest.toModel(autorRepository));

        URI location = ucb.path(BASE_URI + "/{id}").buildAndExpand(livro.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

}
