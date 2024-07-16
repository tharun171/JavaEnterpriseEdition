package com.example.demo.Services;

import java.util.List;

import com.example.demo.BusinessBeans.EmployeeBean;
import com.example.demo.Entities.EmployeeEntity;

public interface EmployeeServicee {

	List<EmployeeEntity> findAllMethod();
	
	EmployeeEntity addMethod();
	
	EmployeeEntity findById(Integer empId);
}
