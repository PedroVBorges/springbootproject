package com.example.restxbrain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class RestxbrainApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestxbrainApplication.class, args);
	}
}
