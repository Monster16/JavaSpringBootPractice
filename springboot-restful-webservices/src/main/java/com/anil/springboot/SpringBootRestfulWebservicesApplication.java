package com.anil.springboot;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Spring boot rest api documentation",
				description = "Spring boot rest api documentation",
				version = "1.0.0",
				contact = @Contact(
						name = "Anil",
						email = "mranilsingh1997@gmail.com",
						url = "google.com"
				),
				license = @License(
						name = "Apache 2.0",
						url = "google.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Spring boot rest api documentation",
				url = "http://localhost:8080/swagger-ui/index.html"
		)
)
public class SpringBootRestfulWebservicesApplication {

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestfulWebservicesApplication.class, args);
	}

}
