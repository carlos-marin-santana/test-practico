package com.carlos.examenpractico;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ExamenPracticoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamenPracticoApplication.class, args);
	}
}
