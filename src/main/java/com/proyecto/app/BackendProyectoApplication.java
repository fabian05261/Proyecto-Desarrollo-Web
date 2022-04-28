package com.proyecto.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan
@SpringBootApplication
public class BackendProyectoApplication {
	
	

	public static void main(String[] args) {
		SpringApplication.run(BackendProyectoApplication.class, args);
	
		
	}

}
