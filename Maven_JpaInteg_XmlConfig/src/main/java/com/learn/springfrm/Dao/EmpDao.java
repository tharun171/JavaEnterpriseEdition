package com.learn.springfrm.Dao;

import java.util.List;

import com.learn.springfrm.Entities.EmployeeEntity;

public interface EmpDao {

public String saveEmployee(EmployeeEntity emp);
	
	public EmployeeEntity findEmployee(Integer empId);
	
	public List<EmployeeEntity> findAll();
}
