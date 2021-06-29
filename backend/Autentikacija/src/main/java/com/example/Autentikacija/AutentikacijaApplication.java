package com.example.Autentikacija;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AutentikacijaApplication {
	public static void main(String[] args) {
		SpringApplication.run(AutentikacijaApplication.class, args);
	}
}