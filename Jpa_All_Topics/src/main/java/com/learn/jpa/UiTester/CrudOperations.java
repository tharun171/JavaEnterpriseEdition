package com.learn.jpa.UiTester;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.learn.jpa.BusinessBeans.EmployeeBean;
import com.learn.jpa.Others.Factory;
import com.learn.jpa.Service.CrudService;


//WORKING
public class CrudOperations {

	public static void main(String[] args) throws Exception {
	
		//CRUD operations
		
		//CREATE Employee
		//createEmployee();
		
		//READ Employee
		//getEmployee(1007);
		
		//UPDATE Employee
		//updateEmployee();
		
		//DELETE Employee
		//deleteEmployee(1004);
		
		//GET ALL Employee
		getAllEmployee();

	}
	public static EmployeeBean deleteEmployee(Integer empId)throws Exception
	{
		EmployeeBean bean = null;
		try
		{
			CrudService service = Factory.createCrudService();
			bean = service.deleteEmployee(empId);
			System.out.println("emp details deleted "+empId+" "+bean);
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return bean;
	}
	public static EmployeeBean getEmployee(Integer empId)throws Exception
	{
		EmployeeBean bean = null;
		try
		{
			CrudService service = Factory.createCrudService();
			bean = service.getEmployee(empId);
			System.out.println("emp details of "+empId+" "+bean);
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return bean;
	}

	public static List<EmployeeBean> getAllEmployee()throws Exception
	{
		List<EmployeeBean> list = null;
		try
		{
			CrudService service = Factory.createCrudService();
			list = service.getAllEmployee();
			for(EmployeeBean e:list)
			{
				System.out.println(e);
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return list;
	}

	public static void createEmployee() throws Exception
	{
		try
		{
			System.out.println("inside create Employee");
			CrudService service = Factory.createCrudService();
			EmployeeBean bean = new EmployeeBean();
			bean.setEmpName("suresh");
			bean.setRole("developer");
			bean.setSalary(66666);
			//year-month-date
			String date = "2023-11-22";
			Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
			bean.setJoiningdate(date1);
			service.createEmployee(bean);
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}

	public static EmployeeBean updateEmployee() throws Exception
	{
		EmployeeBean returnBean = null;
		try
		{
			CrudService service = Factory.createCrudService();
			EmployeeBean bean = new EmployeeBean();
			bean.setEmpId(1005);
			bean.setEmpName("vishnu");
			bean.setRole("developer");
			bean.setSalary(74859);
			String date = "2023-12-5";
			Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
			bean.setJoiningdate(date1);
			returnBean = service.updateEmployee(bean);
			System.out.println("updated details "+returnBean);
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return returnBean;
	}
}
