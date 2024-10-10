package com.redoC_A2k.trainingcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class TrainingcenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainingcenterApplication.class, args);
	}

}
