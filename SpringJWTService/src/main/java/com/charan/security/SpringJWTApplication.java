package com.charan.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.charan")
public class SpringJWTApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJWTApplication.class, args);
	}
}
