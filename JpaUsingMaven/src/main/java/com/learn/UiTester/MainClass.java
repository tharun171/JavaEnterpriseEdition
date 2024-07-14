package com.learn.UiTester;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.learn.Entities.EmployeeEntity;
import com.learn.Others.Factory;
import com.learn.Service.EmpService;


//META-INF/Persistence.xml - have connnection to database
//From JpaUtility - we create em and emf using Persistence.xml
public class MainClass {

	public static void main(String[] args) throws Exception 
	{
		//Run AS - Java application
		//createEmployee();
		getAllEmployee();
	}
	public static List<EmployeeEntity> getAllEmployee()
	{
		List<EmployeeEntity> list = null;
		try
		{
			EmpService service = Factory.createEmpService();
			list = service.getAllEmployee();
			System.out.println("all employee data");
			for(EmployeeEntity e:list)
			{
				System.out.println(e);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return list;
	}
	public static EmployeeEntity createEmployee() throws Exception
	{
		System.out.println("inside create employee");
		EmployeeEntity entity = new EmployeeEntity();
		entity.setEmpName("ramesh");
		entity.setEmpRole("tester");
		entity.setEmpSalary(784596.01);
		String date = "10-12-2023";
		Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse(date);
		entity.setEmpJoined(date1);
		
		EmpService service = Factory.createEmpService();
		EmployeeEntity savedEntity = service.createEmployee(entity);
		System.out.println(savedEntity);
		return savedEntity;
	}
}
