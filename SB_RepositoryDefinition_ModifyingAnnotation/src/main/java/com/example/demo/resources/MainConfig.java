package com.example.demo.resources;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = "com.example.demo")
@EntityScan(basePackages = "com.example.demo.Entities")
@EnableJpaRepositories(basePackages = {"com.example.demo.Dao"})
@Import(SpringDBConfig.class)
public class MainConfig {

}
