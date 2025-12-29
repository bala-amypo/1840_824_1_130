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

        // JWT Security Scheme
        SecurityScheme securityScheme = new SecurityScheme()
                .type(SecurityScheme.Type.HTTP)
                .scheme("bearer")
                .bearerFormat("JWT");

        return new OpenAPI()
                .info(new Info()
                        .title("Warranty Claim Fraud Detection System")
                        .description(
                                "Backend REST API for detecting fraudulent warranty claims " +
                                "using device ownership verification, stolen device tracking, " +
                                "duplicate claim detection, and rule-based fraud alerts."
                        )
                        .version("1.0")
                        .contact(new Contact()
                                .name("Selva Praveen")
                                .email("tsp@gmail.com")
                        )
                )
                .servers(List.of(
                        new Server().url("https://9044.32procr.amypo.ai/")
                ));
                // Enable Authorize button globally
                .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
                .schemaRequirement("bearerAuth", securityScheme);
    }
}


