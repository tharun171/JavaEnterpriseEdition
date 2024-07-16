package com.example.demo;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.BusinessBeans.EmployeeBean;
import com.example.demo.Entities.EmployeeEntity;
import com.example.demo.Services.EmployeeServiceImpl;
import com.example.demo.Services.EmployeeServicee;
import com.example.demo.resources.MainConfigJava;

//WORKING
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SbSpringDataJpaCrudRepoJavaConfigApplication {
	
	private static EmployeeServicee empService;
	
	private static final Logger log = LoggerFactory.getLogger(SbSpringDataJpaCrudRepoJavaConfigApplication.class);

	public static void main(String[] args) {
	
		// TODO Auto-generated method stub
		ApplicationContext ac =
				new AnnotationConfigApplicationContext(MainConfigJava.class);
		empService = ac.getBean(EmployeeServiceImpl.class);
	
		
		//saveEmployee();
		findAll();
		
		((AnnotationConfigApplicationContext)ac).close();
	}
	
	public static String saveEmployee()
	{
		EmployeeBean bean = new EmployeeBean(null,"revi","developer",new Date(),988458.2);
		String result = empService.addEmployee(bean);
		System.out.println(result);
		return result;
	}
	
	public static List<EmployeeEntity> findAll()
	{
		log.info("result ->{}"+empService.findAllMethod());
		return empService.findAllMethod();
	}
}
