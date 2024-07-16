package com.example.demo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.learn.spring.Entities.EmployeeEntity;
import com.learn.spring.Services.EmpService;
import com.learn.spring.Services.EmpServiceImpl;
import com.learn.spring.resources.MainConfigJava;



//WORKING

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ComponentScan(basePackages = "com.learn.spring.*")
public class SbSpringJpaJavaConfigEmPersitenceContextApplication {

	
	private static EmpService empService;
	//private final Logger log = LoggerFactory.getLogger(this.getClass());
	private static final Logger log = LoggerFactory.getLogger(SbSpringJpaJavaConfigEmPersitenceContextApplication.class);
	
	public static void main(String[] args) {
		
		//SpringApplication.run(SbSpringJpaJavaConfigEmPersitenceContextApplication.class, args);
	
		ApplicationContext ac = new AnnotationConfigApplicationContext(MainConfigJava.class);
		empService = ac.getBean(EmpServiceImpl.class);
		
		findAll();
		
		((ConfigurableApplicationContext)ac).close();
	
	}
	public static List<EmployeeEntity> findAll()
	{
		List<EmployeeEntity> list = empService.findAllMethod();
		log.info("result ->{}"+list);
		return list;
	}

}
