package br.com.zup.handora.migrationslivraria.livro;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@SpringBootTest
@AutoConfigureMockMvc
class LivroControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void deveriaCadastrarUmLivro() throws Exception {

        String livroRequestJson = "{\n" + "\"titulo\": \"Livro Teste\",\n" + "\"valor\": 29.99,\n"
                + "\"numeroPaginas\": 200,\n" + "\"isbn\": \"978-0-4745-8789-4\",\n"
                + "\"dataPublicacao\": \"01/01/2001\",\n" + "\"autorId\": 1\n" + "}\n";

        String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();

        mockMvc.perform(
            post(LivroController.BASE_URI).contentType(MediaType.APPLICATION_JSON)
                                          .content(livroRequestJson)
        )
               .andExpect(status().isCreated())
               .andExpect(header().string("location", baseUrl + LivroController.BASE_URI + "/1"));
    }

}
