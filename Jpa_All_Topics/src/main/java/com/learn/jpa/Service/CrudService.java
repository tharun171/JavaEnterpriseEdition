package com.learn.jpa.Service;

import java.util.List;

import com.learn.jpa.BusinessBeans.EmployeeBean;

public interface CrudService {

	public void createEmployee(EmployeeBean bean)throws Exception;
	public EmployeeBean getEmployee(Integer empId)throws Exception;
	public EmployeeBean updateEmployee(EmployeeBean bean)throws Exception;
	public EmployeeBean deleteEmployee(Integer empId) throws Exception;
	public List<EmployeeBean> getAllEmployee() throws Exception;
}
