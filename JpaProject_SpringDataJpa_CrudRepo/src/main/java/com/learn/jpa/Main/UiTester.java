package com.learn.jpa.Main;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.learn.jpa.BusinessBeans.EmployeeBean;
import com.learn.jpa.Entities.EmployeeEntity;
import com.learn.jpa.Service.EmployeeService;
import com.learn.jpa.Service.EmployeeServiceImpl;


//WORKING
public class UiTester {

	private static EmployeeService empService;
	
	public static void main(String[] args)
	{
		
		ApplicationContext ac = new AnnotationConfigApplicationContext(MainConfigJava.class);
		empService = ac.getBean(EmployeeServiceImpl.class);
		
		//saveEmployee();
		
		findAll();
		
		((AnnotationConfigApplicationContext)ac).close();
	}
	
	public static void saveEmployee()
	{
		EmployeeBean bean = new EmployeeBean(null,"ramesh","tester",new Date(),852147.9);
		empService.saveEmployee(bean);
	}
	
	public static List<EmployeeEntity> findAll()
	{
		List<EmployeeEntity> list = empService.findAll();
		for(EmployeeEntity var:list)
		{
			System.out.println(var.toString());
		}
		return list;
	}
}
