package com.entra21;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Entra21ProjetoFinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(Entra21ProjetoFinalApplication.class, args);
		
		Locale.setDefault(Locale.US);
	}

}
