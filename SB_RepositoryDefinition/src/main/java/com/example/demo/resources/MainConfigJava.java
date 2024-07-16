package com.example.demo.resources;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "com.example.demo")
@EntityScan(basePackages = "com.example.demo.Entities")
@Import(SpringDBConfig.class)
public class MainConfigJava {

}
