package com.learn.orm.Service;

import java.util.List;

import com.learn.orm.BusinessBeans.EmployeeBean;
import com.learn.orm.Entities.EmployeeEntity;

public interface EmpService {

	List<Object> stringFucntionsDemo();
	List<Object> dateFunctionsDemo();
	List<Object> MathFunctions();
	
	int insertEmployee(EmployeeBean bean)throws Exception;

	EmployeeBean updateSalaryOfEmployeeWithNameAs(String name,double salary);
	 
	EmployeeBean getEmployeeById(int id);

	List<EmployeeBean> salaryInRange(double salary1,double salary2);
	
	List<EmployeeBean> NameLikeSubstringSalaryDesc(String subString);
	
	//named queries in orm.xml
	List<EmployeeEntity> findEmpByNameAndRolePositionalParam(String name,String role);
	List<EmployeeEntity> findEmpByNameNamedParam(String name);
	List<EmployeeEntity> findAllEmpFromXML();
	
	//Hibernate provider
		List<EmployeeBean> getEmployeeDetailsUsingHibernateProvider();

}
