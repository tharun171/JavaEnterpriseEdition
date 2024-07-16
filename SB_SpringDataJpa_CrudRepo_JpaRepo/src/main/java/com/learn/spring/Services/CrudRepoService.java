package com.learn.spring.Services;

import java.util.List;

import com.learn.spring.Entities.EmployeeEntity;

public interface CrudRepoService {

EmployeeEntity saveEmployee(EmployeeEntity emp);
	
	List<EmployeeEntity> getAll();
	
	EmployeeEntity getById(Integer id);
	
	EmployeeEntity updateEmp(EmployeeEntity emp);
	
	String deleteById(Integer id);
}
