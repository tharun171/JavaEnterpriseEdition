package com.example.demo.Services;

import java.util.List;

import com.example.demo.Entities.EmployeeEntity;

public interface EmployeeService {

	List<EmployeeEntity> findAllMethod();
	
	List<EmployeeEntity> findEmployeeSalaryGreaterThan(Double salary);
	
	List<EmployeeEntity> findEmployeeSalaryGreaterThanNamed(Double salary);
}
