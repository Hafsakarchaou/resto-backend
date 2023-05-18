package com.example.demo;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication

@EntityScan({"com.example.entities"})
@ComponentScan({"com.example.service","com.example.controller"})
@EnableJpaRepositories("com.example.repository")
public class TpApplication {
		
	public static void main(String[] args) {
		SpringApplication.run(TpApplication.class,args);
	}
}


