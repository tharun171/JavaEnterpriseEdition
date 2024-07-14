package com.learn.springfrm.UiTester;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.learn.springfrm.Entities.EmployeeEntity;
import com.learn.springfrm.Service.EmpService;
import com.learn.springfrm.resources.MainConfigJava;

public class MainClass{
	
	private static EmpService empService;
	
	public static void main(String[] args) throws ParseException {
		
		ApplicationContext ac = new AnnotationConfigApplicationContext(MainConfigJava.class);
    	empService = (EmpService) ac.getBean("empServiceImpl");
    	
		// Use employeeService as needed
		//saveEmployee();
		// 1001 is the starting
		//findEmployee(1015);
		//find All Employees
		findAll();

		// Close the context when done
		((ConfigurableApplicationContext) ac).close();
	}

	public static String saveEmployee() throws ParseException {
		String date = "18-DEC-2022";
		Date joinDate = new SimpleDateFormat("dd-MMM-yyyy").parse(date);
		//passing 0 as default id
		EmployeeEntity emp = new EmployeeEntity();
		emp.setEmpId(null);
		emp.setEmpGender('M');
		emp.setEmpName("Suresh");
		emp.setEmpSalary(45465.215);
		emp.setEmpRole("dev");
		emp.setEmpJoined(joinDate);
		String returnMessage = empService.saveEmployee(emp);
		System.out.println("result " + returnMessage);
		return returnMessage;
	}

	public static EmployeeEntity findEmployee(Integer id) {
		EmployeeEntity entity = empService.findEmployee(id);
		System.out.println("entity details with id " + id + " " + entity);
		return entity;
	}
	
	public static List<EmployeeEntity> findAll()
	{
		List<EmployeeEntity> list = empService.findAll();
		Iterator<EmployeeEntity> itr = list.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
		/*
		for(EmployeeEntity var:list)
		{
			System.out.println(var);
		}
		*/
		return list;
	}
}
