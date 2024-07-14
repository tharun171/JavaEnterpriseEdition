package com.learn.springfrm.Service;

import java.util.List;

import com.learn.springfrm.Entities.EmployeeEntity;

public interface EmpService {

public String saveEmployee(EmployeeEntity emp);
	
	public EmployeeEntity findEmployee(Integer empId);
	
	public List<EmployeeEntity> findAll();
}
