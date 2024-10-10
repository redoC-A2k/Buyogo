package com.redoC_A2k.trainingcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(info = @Info(
	title = "Buyogo assignment API Documentation", 
	description = "This is swagger documentation for Buyogo assignment",
	contact = @Contact(
		name = "Afshan Ahmed Khan",
		email = "afshanahmeda2k@gmail.com",
		url = "https://www.eazybank.com"
	))
)
@EnableJpaAuditing
@SpringBootApplication
public class TrainingcenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainingcenterApplication.class, args);
	}

}
