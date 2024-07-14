package com.learn.springfrm.resources;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = {"com.learn.springfrm.*"})
@EnableJpaRepositories(basePackages = {"com.learn.springfrm.*"},
entityManagerFactoryRef = "entityManagerFactory",
transactionManagerRef = "txManager")
@Import(SpringConfigJava.class)
@EnableTransactionManagement
public class MainConfigJava {

}
