package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ComponentScan(basePackages = "com.example.demo")
public class SbSpringMvc06CustomExceptionPageApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbSpringMvc06CustomExceptionPageApplication.class, args);
	}

}
