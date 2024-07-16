package com.example.demo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.Entities.EmployeeEntity;
import com.example.demo.Services.EmployeeService;
import com.example.demo.Services.EmployeeServiceImpl;
import com.example.demo.resources.MainConfigJava;


//WORKING


//excluding default DB config from app.prop
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SbRepositoryDefinitionApplication {

	private static EmployeeService empService;
	
	private static final Logger log = 
			LoggerFactory.getLogger(SbRepositoryDefinitionApplication.class);
	
	public static void main(String[] args) {
		//SpringApplication.run(SbRepositoryDefinitionApplication.class, args);
	
		ApplicationContext ac = new AnnotationConfigApplicationContext(
				MainConfigJava.class);
		
		empService = ac.getBean(EmployeeServiceImpl.class);
		
		findAll();
		
		//findEmployeeSalaryGreaterThan(999999.0);
		
		//findEmployeeSalaryGreaterThanNamedQuery(999999.0);
		
		((AnnotationConfigApplicationContext)ac).close();
	
	}

	public static List<EmployeeEntity> findAll()
	{
		List<EmployeeEntity> list = empService.findAllMethod();
		log.info("result ->{}"+list);
		return list;
	}
	
	public static List<EmployeeEntity> findEmployeeSalaryGreaterThan(Double salary)
	{
		System.out.println("positional parameter - RepDefinition");
		List<EmployeeEntity> list = empService.findEmployeeSalaryGreaterThan(salary);
		return list;
	}
	
	public static List<EmployeeEntity> findEmployeeSalaryGreaterThanNamedQuery(Double salary)
	{
		System.out.println("positional parameter - RepDefinition");
		List<EmployeeEntity> list = empService.findEmployeeSalaryGreaterThanNamed(salary);
		return list;
	}
}
