package com.example.springcicddemo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class Springcicddemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Springcicddemo1Application.class, args);
	}

}
