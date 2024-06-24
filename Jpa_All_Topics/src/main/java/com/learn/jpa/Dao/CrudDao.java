package com.learn.jpa.Dao;

import java.util.List;

import com.learn.jpa.BusinessBeans.EmployeeBean;

public interface CrudDao {

	public void createEmployee(EmployeeBean bean)throws Exception;
	
	public EmployeeBean getEmployee(Integer empId)throws Exception;
	
	public EmployeeBean updateEmployee(EmployeeBean bean)throws Exception;
	
	public EmployeeBean deleteEmployee(Integer empId) throws Exception;
	
	public List<EmployeeBean> getAllEmployee() throws Exception;
}
