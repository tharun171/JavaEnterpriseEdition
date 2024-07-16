package com.example.demo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.Entities.EmployeeEntity;
import com.example.demo.Services.EmployeeServiceImpl;
import com.example.demo.Services.EmployeeServicee;
import com.example.demo.resources.MainConfigJava;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SbSpringDataJpaCrudRepoTransactionMethodsApplication {

	private static EmployeeServicee empService;
	
	private static final Logger log = LoggerFactory.getLogger(SbSpringDataJpaCrudRepoTransactionMethodsApplication.class);

	
	public static void main(String[] args) {
		//SpringApplication.run(SbSpringDataJpaCrudRepoTransactionMethodsApplication.class, args);
	
		ApplicationContext ac = new AnnotationConfigApplicationContext(MainConfigJava.class);
		empService = ac.getBean(EmployeeServiceImpl.class);
		
		//normal method with normal transaction
		//findAll();
		
		//Doesnt Work Bcoz Tranction is readonly
		//readonly doesnt allow to write
		//AddEmployee();
		/*
		 12:42:44.465 [main] DEBUG org.hibernate.engine.jdbc.spi.SqlExceptionHelper - could not execute statement [n/a]
		 java.sql.SQLException: Connection is read-only. Queries leading to data modification are not allowed
		 */
		
		
		findById(4);
		//we give Transaction timeout 3 seconds
		//means after 3 seconds it wont work
		//we use thread and sleep method 5 seconds
		/*
		 * 20:03:30.053 [main] INFO org.hibernate.event.internal.DefaultLoadEventListener -- HHH000327: Error performing load command
		 * Caused by: org.hibernate.TransactionException: transaction timeout expired
		 */
	
		
		((AnnotationConfigApplicationContext)ac).close();
	}
	
	public static List<EmployeeEntity> findAll()
	{
		log.info("result ->{}"+empService.findAllMethod());
		return empService.findAllMethod();
	}
	
	public static EmployeeEntity AddEmployee()
	{
		log.info("add ->{}"+empService.addMethod());
		return empService.addMethod();
	}
	
	public static EmployeeEntity findById(Integer empId)
	{
		log.info("findbyid -> "+empService.findById(empId));
		return empService.findById(empId);
	}
}
