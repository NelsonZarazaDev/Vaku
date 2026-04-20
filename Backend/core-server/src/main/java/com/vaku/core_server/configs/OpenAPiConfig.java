package com.vaku.core_server.configs;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Microservice core",
                version = "1.0.0",
                description = "This is a CRUD for core"
        )
)
public class OpenAPiConfig {
}
