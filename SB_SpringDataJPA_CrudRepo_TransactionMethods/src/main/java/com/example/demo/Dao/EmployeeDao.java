package com.example.demo.Dao;

import java.util.List;

import com.example.demo.Entities.EmployeeEntity;

public interface EmployeeDao {


	List<EmployeeEntity> findAllMethod();
	
	EmployeeEntity addMethod();
	
	EmployeeEntity findById(Integer empId);
}
