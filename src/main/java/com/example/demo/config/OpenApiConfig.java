package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        OpenAPI openAPI = new OpenAPI();

        Info info = new Info();
        info.setTitle("Warranty Claim Fraud Detection System");
        info.setDescription("REST API for detecting fraudulent warranty claims");
        info.setVersion("1.0");

        Contact contact = new Contact();
        contact.setName("Selva Praveen");
        contact.setEmail("abiselvi1823@gmail.com");
        info.setContact(contact);

        openAPI.setInfo(info);

        openAPI.setServers(List.of(
                new Server().url("https://9044.32procr.amypo.ai")
        ));

        return openAPI;
    }
}
