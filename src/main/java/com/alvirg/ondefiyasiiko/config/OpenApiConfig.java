package com.alvirg.ondefiyasiiko.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(

        security = {
                @SecurityRequirement(name = "bearerAuth")
        },
        info = @Info(
                contact = @Contact(
                        name = "onde fiya siiko fishing festival",
                        email = "contact@creekscholar.com",
                        url = "https://ondefiyasiiko.com/festival"
                ),
                description = "OpenApi documentation for Onde fiya siiko festival website",
                title = "OpenApi specification",
                version = "1.0",
                license = @License(
                        name = "License name",
                        url = "https://albertegi-url.com"
                ),
                termsOfService = "Terms of service"

        ),
        servers = {
                @Server(
                        description = "Local ENV",
                        url = "http://localhost:8080"
                ),
                @Server(
                        description = "Local PROD",
                        url = "http://ondefiyasiiko.com/festival"
                )

        }
)
@SecurityScheme(
        name = "bearerAuth",
        description = "JWT auth description",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)
public class OpenApiConfig {
}
