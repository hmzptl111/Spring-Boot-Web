package com.rest.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.rest")
public class FactorialPalindromeResTfulApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FactorialPalindromeResTfulApiApplication.class, args);
	}

}
