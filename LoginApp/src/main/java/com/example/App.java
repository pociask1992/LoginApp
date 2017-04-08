package com.example;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

@Configuration
@EnableAutoConfiguration
@ComponentScan({"com.example",
	"com.example.configuration",
	"com.example.controller",
	"com.example.service",	
	"org.example.springproject"})
@EntityScan(basePackages = {"com.example.domain"})
@EnableJpaRepositories(basePackages = {"com.example.repository"})
public class App extends RepositoryRestMvcConfiguration {

	
	public static void main(String[] args) throws IOException{
		
		SpringApplication.run(App.class, args);
		
	}

}
