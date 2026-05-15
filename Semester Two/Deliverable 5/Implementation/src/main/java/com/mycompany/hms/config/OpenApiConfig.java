package com.mycompany.hms.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * OpenAPI/Swagger Configuration
 * Configures Swagger UI documentation for the Hospital Management System API
 * Access at: http://localhost:8080/swagger-ui/index.html
 */
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Hospital Management System API")
                        .version("1.0.0")
                        .description("""
                                RESTful API for the Hospital Management System — Deliverable 5.
                                
                                **Services:**
                                - Patient Service: Manage patient records
                                - Doctor Service: Manage doctor information
                                - Appointment Service: Schedule and manage appointments
                                - Composite Service: Book appointments with orchestration
                                
                                **Features:**
                                - Full CRUD operations for all entities
                                - Input validation with detailed error messages
                                - Proper HTTP status codes
                                - Exception handling
                                """)
                        .contact(new Contact()
                                .name("SW311 Team")
                                .email("team@hospital.com")))
                .servers(List.of(
                        new Server()
                                .url("http://localhost:8080")
                                .description("Local Development Server")
                ));
    }
}
