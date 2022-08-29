package com.openclassroom.microservice.clientui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.openclassroom.microservice")
public class Projet9MediscreenClientUiApplication {

	public static void main(String[] args) {
		SpringApplication.run(Projet9MediscreenClientUiApplication.class, args);
	}

}
