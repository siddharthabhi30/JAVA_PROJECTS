package com.example.Relience4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Relience4jApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(Relience4jApplication.class);

	private static final String MAIN_SERVICE = "mainService";

	public static void main(String[] args) {
		SpringApplication.run(Relience4jApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate() {

		return new RestTemplate();
	}

}
