package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ComponentScan(basePackages = "com.example.demo")
public class SbSpringMvc02SpringFormsDynamicFormsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbSpringMvc02SpringFormsDynamicFormsApplication.class, args);
	}

}
