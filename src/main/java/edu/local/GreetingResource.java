package edu.local;

import io.smallrye.mutiny.Multi;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;

import java.time.Duration;
import java.util.stream.Stream;

@Path("/hello")
@RequestScoped
@RequiredArgsConstructor
public class GreetingResource {

    @GET
    @Produces(MediaType.SERVER_SENT_EVENTS)
    public Multi<Integer> integerStream(){
        return Multi.createFrom().ticks().every(Duration.ofSeconds(2))
                .onItem().transform(Long::intValue);
    }

    @GET
    @Path("/get-site")
    @Produces(MediaType.TEXT_HTML)
    @Transactional
    public String hello() {
        MyEntity.persist(new MyEntity("field", "value"));
        return "<!DOCTYPE html>\n" +
                "<html lang=\"pt-br\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Minha Página Web</title>\n" +
                "    <link rel=\"stylesheet\" href=\"styles.css\"> <!-- Link para um arquivo CSS externo -->\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "    <!-- Cabeçalho -->\n" +
                "    <header>\n" +
                "        <h1>Bem-vindo ao Meu Site</h1>\n" +
                "        <nav>\n" +
                "            <ul>\n" +
                "                <li><a href=\"#home\">Início</a></li>\n" +
                "                <li><a href=\"#about\">Sobre</a></li>\n" +
                "                <li><a href=\"#services\">Serviços</a></li>\n" +
                "                <li><a href=\"#contact\">Contato</a></li>\n" +
                "            </ul>\n" +
                "        </nav>\n" +
                "    </header>\n" +
                "\n" +
                "    <!-- Conteúdo Principal -->\n" +
                "    <main>\n" +
                "        <section id=\"home\">\n" +
                "            <h2>Início</h2>\n" +
                "            <p>Bem-vindo ao nosso site! Navegue para saber mais sobre nossos serviços e equipe.</p>\n" +
                "        </section>\n" +
                "        \n" +
                "        <section id=\"about\">\n" +
                "            <h2>Sobre Nós</h2>\n" +
                "            <p>Somos uma empresa dedicada a fornecer as melhores soluções para nossos clientes.</p>\n" +
                "        </section>\n" +
                "\n" +
                "        <section id=\"services\">\n" +
                "            <h2>Serviços</h2>\n" +
                "            <ul>\n" +
                "                <li>Desenvolvimento Web</li>\n" +
                "                <li>Consultoria de TI</li>\n" +
                "                <li>Marketing Digital</li>\n" +
                "            </ul>\n" +
                "        </section>\n" +
                "    </main>\n" +
                "\n" +
                "    <!-- Rodapé -->\n" +
                "    <footer>\n" +
                "        <p>&copy; 2024 Minha Empresa. Todos os direitos reservados.</p>\n" +
                "    </footer>\n" +
                "\n" +
                "</body>\n" +
                "</html>";
    }
}
