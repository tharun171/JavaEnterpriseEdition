package com.example.demo.Main;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.BusinessBeans.EmployeeBean;
import com.example.demo.Entities.EmployeeEntity;
import com.example.demo.Services.EmployeeServiceImpl;
import com.example.demo.Services.EmployeeServicee;
import com.example.demo.resources.MainConfigJava;

public class UiTester {

	//WORKING
	//Run As - Java Application
	
	private static EmployeeServicee empService;
	
	private static final Logger log = 
			LoggerFactory.getLogger(UiTester.class);
	
	public static void main(String[] args)
	{
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
		EmployeeBean bean = new EmployeeBean(null,"lulu","developer",new Date(),988458.2);
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
