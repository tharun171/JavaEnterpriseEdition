package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


//WORKING
//validation messages are from messages_en.properties


@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ComponentScan(basePackages = "com.example.demo")
public class SbSpringMvc04StandardValidationsFileApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbSpringMvc04StandardValidationsFileApplication.class, args);
	}

}
