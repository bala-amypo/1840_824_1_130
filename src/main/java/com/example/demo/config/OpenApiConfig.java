package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        SecurityScheme securityScheme = new SecurityScheme()
                .name("bearerAuth")
                .type(SecurityScheme.Type.HTTP)
                .scheme("bearer")
                .bearerFormat("JWT");

        return new OpenAPI()
                .info(new Info()
                        .title("Warranty Claim Fraud Detection System")
                        .description(
                                "Backend REST API for detecting fraudulent warranty claims " +
                                "using device ownership verification, stolen device tracking, " +
                                "and rule-based fraud detection."
                        )
                        .version("1.0")
                        .contact(new Contact()
                                .name("Selva Praveen")
                                .email("abiselvi1823@gmail.com")
                        )
                )
                .servers(List.of( new Server().url("https://9044.32procr.amypo.ai/") ));
                .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
                .components(
                        new io.swagger.v3.oas.models.Components()
                                .addSecuritySchemes("bearerAuth", securityScheme)
                );
    }
}
