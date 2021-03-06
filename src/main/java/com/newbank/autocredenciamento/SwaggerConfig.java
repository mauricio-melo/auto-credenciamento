package com.newbank.autocredenciamento;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class)) // Apenas classes anotadas como @RestController
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaData());
    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("API REST - Application Autocredenciamento")
                .description("Através desta API será possível que o cliente faça seu autocredenciamento no banco.")
                .termsOfServiceUrl("https://github.com/mauricio-melo")
                .contact(new Contact("Mauricio Ribeiro de Melo", "https://www.linkedin.com/in/mauriciormelo/", "mauriciomelo.contato@outlook.com"))
                .license("Licença")
                .licenseUrl("https://github.com/mauricio-melo")
                .version("1.0.0-SNAPSHOT")
                .build();
    }
}