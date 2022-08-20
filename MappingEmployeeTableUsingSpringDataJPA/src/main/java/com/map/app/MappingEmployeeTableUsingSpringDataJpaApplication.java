package com.map.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.map.presentation.EmployeePresentation;

@SpringBootApplication(scanBasePackages = "com.map")
@EntityScan(basePackages = "com.map.bean")
@EnableJpaRepositories(basePackages = "com.map.persistence")
public class MappingEmployeeTableUsingSpringDataJpaApplication implements CommandLineRunner {
	@Autowired
	private EmployeePresentation employeePresentation;

	public static void main(String[] args) {
		SpringApplication.run(MappingEmployeeTableUsingSpringDataJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		while(true) {
			employeePresentation.menu();
		}
	}
}
