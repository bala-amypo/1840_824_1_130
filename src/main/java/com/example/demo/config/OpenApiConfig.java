package com.example.demo.config;

import io.swagger.v3.oas.models.Components;
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

        // 1️⃣ Define JWT Bearer Security Scheme
        SecurityScheme bearerScheme = new SecurityScheme();
        bearerScheme.setType(SecurityScheme.Type.HTTP);
        bearerScheme.setScheme("bearer");
        bearerScheme.setBearerFormat("JWT");

        Components components = new Components();
        components.addSecuritySchemes("bearerAuth", bearerScheme);

        // 2️⃣ API Info
        Info info = new Info();
        info.setTitle("Warranty Claim Fraud Detection System");
        info.setDescription(
                "Backend REST API for detecting fraudulent warranty claims " +
                "using device ownership verification and rule-based fraud detection."
        );
        info.setVersion("1.0");

        Contact contact = new Contact();
        contact.setName("Selva Praveen");
        contact.setEmail("abiselvi1823@gmail.com");
        info.setContact(contact);

        // 3️⃣ Build OpenAPI
        OpenAPI openAPI = new OpenAPI();
        openAPI.setInfo(info);
        openAPI.setComponents(components);

        // 4️⃣ Enable Authorize button globally
        openAPI.setSecurity(List.of(
                new SecurityRequirement().addList("bearerAuth")
        ));

        // 5️⃣ Servers
        openAPI.setServers(List.of(
               
                new Server().url("https://9044.32procr.amypo.ai")
        ));

        return openAPI;
    }
}
