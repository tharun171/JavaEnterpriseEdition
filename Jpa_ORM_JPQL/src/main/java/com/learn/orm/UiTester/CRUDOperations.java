package com.learn.orm.UiTester;

import java.util.Date;
import java.util.List;

import com.learn.orm.BusinessBeans.EmployeeBean;
import com.learn.orm.Entities.EmployeeEntity;
import com.learn.orm.Others.Factory;
import com.learn.orm.Service.EmpService;

public class CRUDOperations {

	private static EmpService empService;
	
	public static void main(String[] args) {
		try
		{
		//insertEmployee();
		
		//updateSalaryOfEmployeeWithNameAs("msd",(double)99000.123);
		 
		//getEmployeeById(1005);
		
		//get employees in range
		//salaryInRange(70000,80000);
		
		//get data names having 'mes'
		//sort the data in descending order
		//NameLikeSubstringSalaryDesc("mes");
		
		//Queries are written in orm.xml
		//named queries
		//findEmpByNameAndRolePositionalParam("ramesh","developer");
		//findEmpByNameNamedParam("msd");
		//findAllEmpFromXML();
		
		
		//Hibernate Provider - from EmployeeEntity will be the query, nothing much.
		getEmployeeDetailsUsingHibernateProvider();
		
			
		}
		catch(Exception ex)
		{
			ex.getStackTrace();
			System.out.println(ex.getMessage());
		}
	}
	public static List<EmployeeBean> getEmployeeDetailsUsingHibernateProvider() {
		// TODO Auto-generated method stub
		empService = Factory.createEmpService();
		List<EmployeeBean> returnList =  empService.getEmployeeDetailsUsingHibernateProvider();
		for(EmployeeBean bean:returnList)
		{
			System.out.println(bean);
		}
		return returnList;
	}
	
	public static List<EmployeeEntity> findEmpByNameAndRolePositionalParam(String name,String role)
	{
		empService = Factory.createEmpService();
		return empService.findEmpByNameAndRolePositionalParam(name, role);
	}
	public static List<EmployeeEntity> findEmpByNameNamedParam(String name)
	{
		empService = Factory.createEmpService();
		return empService.findEmpByNameNamedParam(name);
	}
	public static List<EmployeeEntity> findAllEmpFromXML()
	{
		empService = Factory.createEmpService();
		return empService.findAllEmpFromXML();
	}
	
	public static List<EmployeeBean> salaryInRange(double salary1,double salary2)
	{
		empService = Factory.createEmpService();
		return empService.salaryInRange(salary1, salary2);
	}
	
	public static List<EmployeeBean> NameLikeSubstringSalaryDesc(String subString)
	{
		empService = Factory.createEmpService();
		return empService.NameLikeSubstringSalaryDesc(subString);
		
	}
	
	public static EmployeeBean updateSalaryOfEmployeeWithNameAs(String name,Double salary)
	{
		empService= Factory.createEmpService();
		return empService.updateSalaryOfEmployeeWithNameAs(name,salary);
	}
	
	public static EmployeeBean getEmployeeById(int id)
	{
		empService = Factory.createEmpService();
		return empService.getEmployeeById(id);
	}
	
	public static int insertEmployee() throws Exception
	{
		EmployeeBean bean = new EmployeeBean();
		bean.setEmployeeName("luke");
		bean.setRole("developer");
		bean.setSalary(784565.2);
		bean.setInsertTime(new Date());
		empService = Factory.createEmpService();
		return empService.insertEmployee(bean);
		
	}
	

}
