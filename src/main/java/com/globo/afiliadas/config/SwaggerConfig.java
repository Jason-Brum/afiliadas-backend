package com.globo.afiliadas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI afiliadasOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("API de Afiliadas Globo")
                .description("API para gerenciamento de afiliadas, lançamentos, categorias e tipos de lançamento.")
                .version("1.0.0")
                .contact(new Contact()
                    .name("Equipe Técnica Globo")
                    .email("suporte@globo.com.br")
                    .url("https://globo.com")));
    }
}
