package config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Steve"
                )
        ),
        servers = {
                @Server(
                        description = "Local Env",
                        url = "http://localhost:5051/api/v1"
                )
        }
)
public class OpenApiConfig {
}
