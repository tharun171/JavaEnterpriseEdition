package com.learn.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.learn.spring","com.learn.spring.ProjectDao"})
public class SbSpringDataJpaCrudRepoJpaRepoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbSpringDataJpaCrudRepoJpaRepoApplication.class, args);
	
	
	}

}
