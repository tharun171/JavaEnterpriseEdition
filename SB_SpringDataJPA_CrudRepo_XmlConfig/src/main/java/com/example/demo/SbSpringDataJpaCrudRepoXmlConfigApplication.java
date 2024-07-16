package com.example.demo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.demo.BusinessBeans.EmployeeBean;
import com.example.demo.Entities.EmployeeEntity;
import com.example.demo.Services.EmployeeService;
import com.example.demo.Services.EmployeeServiceImpl;

@SpringBootApplication
public class SbSpringDataJpaCrudRepoXmlConfigApplication {
	
	public static EmployeeService empService;

	public static void main(String[] args) {
		//SpringApplication.run(SbSpringDataJpaCrudRepoXmlConfigApplication.class, args);
	
		ApplicationContext ac = new ClassPathXmlApplicationContext
				("com/example/demo/resources/MainConfig.xml");
		
		empService = ac.getBean("employeeServiceImpl",EmployeeServiceImpl.class);
		
		
		//findAllMethod();
		
		//saveAllMethod();
		
		//findByIdMethod(8);
		
		countMethod();
	
		((ClassPathXmlApplicationContext)ac).close();
	}

	public static void saveEmployee()throws Exception
    {
    	EmployeeBean bean = new EmployeeBean(null,"tillu","developer",new Date(),900000.9);
    	empService.saveEmployee(bean);
    }
	
	public static void saveAllMethod()
	{
		List<EmployeeBean> BeansList = new ArrayList<EmployeeBean>();
		EmployeeBean bean1 = new EmployeeBean(null,"akshatha","operations analyst",new Date(),99999.9);
		EmployeeBean bean2 = new EmployeeBean(null,"revesh","HR",new Date(),45623.23);
		BeansList.add(bean1);
		BeansList.add(bean2);
		empService.saveAllMethod(BeansList);
	}
	
	public static EmployeeBean findByIdMethod(Integer empId)
	{
		//findById() - returns entity or optional if null
		EmployeeBean bean = empService.findByIdMethod(empId);
		return bean;
	}
	
	public static Boolean existsByIdMethod(Integer empId)
	{
		//returns boolean
		boolean result = empService.existsByIdMethod(empId);
		return result;
	}
	
	public static List<EmployeeEntity> findAllMethod()
	{
		//findAll() get all instances
		return empService.findAllMethod();
	}
	
	public static List<EmployeeEntity> findAllById(List<Integer> ids)
	{
		//findAllById(list of ids) 
		List<EmployeeEntity> list = empService.findAllById(ids);
		for(EmployeeEntity var:list)
		{
			System.out.println(var.toString());
		}
		return empService.findAllById(ids);
	}
	
	public static Integer countMethod()
	{
		Integer totalEntities = empService.countMethod();
		return totalEntities;
	}
}
