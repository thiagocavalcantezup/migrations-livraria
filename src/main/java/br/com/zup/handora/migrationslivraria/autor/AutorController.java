package br.com.zup.handora.migrationslivraria.autor;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(AutorController.BASE_URI)
public class AutorController {

    public final static String BASE_URI = "/autores";

    private final AutorRepository autorRepository;

    public AutorController(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid AutorRequest autorRequest,
                                    UriComponentsBuilder ucb) {
        Autor autor = autorRepository.save(autorRequest.toModel());

        URI location = ucb.path(BASE_URI + "/{id}").buildAndExpand(autor.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

}
