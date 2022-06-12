package com.torresdevelop.usuarios.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.javafaker.Faker;

@Configuration
public class FakerBeansConfig {
	
	@Bean // Puerta de Enlace al metodo
	public Faker getFaker() {
		return new Faker();
	}

}
