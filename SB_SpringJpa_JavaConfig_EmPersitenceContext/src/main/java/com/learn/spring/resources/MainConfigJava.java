package com.learn.spring.resources;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan({"com.learn.spring.Dao,com.learn.spring.Services"})
@EnableJpaRepositories(basePackages = {"com.learn.spring.Dao"})
@Import(SpringDbConfig.class)
public class MainConfigJava {

	
}
