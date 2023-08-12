package io.swagger.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2023-08-12T06:05:54.271Z")

@Configuration
public class SwaggerDocumentationConfig {

    ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("Spring Framework Guru")
            .description("Spring Framework 5: Beginner to Guru")
            .license("Apache License Version 2.0")
            .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
            .termsOfServiceUrl("https://springframework.guru/about/")
            .version("1.0")
            .contact(new Contact("","", "john@springfrmework.guru"))
            .build();
    }

    @Bean
    public Docket customImplementation(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                    .apis(RequestHandlerSelectors.basePackage("io.swagger.api"))
                    .build()
                .directModelSubstitute(org.threeten.bp.LocalDate.class, java.sql.Date.class)
                .directModelSubstitute(org.threeten.bp.OffsetDateTime.class, java.util.Date.class)
                .apiInfo(apiInfo());
    }

}
