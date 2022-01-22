package ec.edu.espe.arquitectura.examen.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI showOpenAPI(){
        return new OpenAPI()
                .info(new Info().title("API del Registro Civil")
                        .description("Sistema Externo del Registro Civil")
                        .version("v2.0.0")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("Repositorio del Proyecto")
                        .url("https://gitlab.com/banco-banquito/registro-civil_sistemas-externos_BBQ"));
    }
}
