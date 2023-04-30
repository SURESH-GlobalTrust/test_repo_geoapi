package com.globaltrust.geodata.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration

public class OpenAPIConfig {

    @Value("${globlatrust.openapi.dev-url}")
    private String devUrl;

    @Value("${globlatrust.openapi.prod-url}")
    private String prodUrl;

    @Bean
    public OpenAPI myOpenAPI() {
        Server devServer = new Server();
        devServer.setUrl(devUrl);
        devServer.setDescription("Server URL in Development environment");

        Server prodServer = new Server();
        prodServer.setUrl(prodUrl);
        prodServer.setDescription("Server URL in Production environment");

        Contact contact = new Contact();
        contact.setEmail("samaresh.das@globaltrustgrp.com");
        contact.setName("Samaresh Das");
        contact.setUrl("https://globaltrustgrp.com/");

        License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

        Info info = new Info()
                .title("GlobalTrust GEO Data API")
                .version("1.0")
                .contact(contact)
                .description("This API exposes endpoints to manage GEO Spatial data.").termsOfService("https://globaltrustgrp.com/terms")
                .license(mitLicense);

        return new OpenAPI().info(info).servers(List.of(devServer, prodServer));
    }
}
/*
public OpenAPI customOpenAPI(@Value("${springdoc.version}") String appVersion) {
		return new OpenAPI()
				.components(new Components())
				.info(new Info().title("Customer accounts API").version(appVersion)
						.license(new License().name("Apache 2.0").url("http://springdoc.org")));
	}
 */