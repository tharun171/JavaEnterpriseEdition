package com.learn.jpa.Service;

import java.util.List;

import com.learn.jpa.BusinessBeans.EmployeeBean;
import com.learn.jpa.Entities.EmployeeEntity;

public interface EmployeeService {

	void saveEmployee(EmployeeBean bean);
	
	List<EmployeeEntity> findAll();
}
