package com.example.demo.Services;

import java.util.List;

import com.example.demo.BusinessBeans.EmployeeBean;

public interface EmployeeService {

	Integer addEmployee(EmployeeBean bean)throws Exception;
	List<EmployeeBean> getAllEmployee()throws Exception;
	EmployeeBean getEmployeeById(Integer id);
	EmployeeBean updateEmployee(EmployeeBean bean);
	String deleteEmployeeById(Integer id);
	List<EmployeeBean> getEmpDetailsRange(Double min,Double max);
	
}
