package com.example.demo.Dao;

import java.util.List;

import com.example.demo.Entities.EmployeeEntity;

public interface EmployeeDao {

	List<EmployeeEntity> findAllMethod();
	
	List<EmployeeEntity> findEmployeeSalaryGreaterThan(Double salary);
	
	List<EmployeeEntity> findEmployeeSalaryGreaterThanNamed(Double salary);
	
}
