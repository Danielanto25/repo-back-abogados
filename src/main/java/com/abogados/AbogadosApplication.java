package com.abogados;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AbogadosApplication {

	public static void main(String[] args) {
		SpringApplication.run(AbogadosApplication.class, args);
	}

}
