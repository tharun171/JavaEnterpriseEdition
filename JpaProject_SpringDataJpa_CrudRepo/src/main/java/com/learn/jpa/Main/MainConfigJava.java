package com.learn.jpa.Main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;


@Configuration
@ComponentScan(basePackages = "com.learn.jpa")
@EnableJpaRepositories(basePackages = "com.learn.jpa.Dao")
@EnableTransactionManagement
public class MainConfigJava {
	 @Bean
	    public EntityManagerFactory entityManagerFactory() {
	        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
	        emf.setPersistenceUnitName("JpaProject_SpringDataJpa_CrudRepo");
	        emf.afterPropertiesSet();
	        return emf.getObject();
	    }
	 
	 
	  @Bean(name = "transactionManager")
	    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
	        return new JpaTransactionManager(entityManagerFactory);
	    }

}
