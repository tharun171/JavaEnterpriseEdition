package com.learn.Service;

import java.util.List;

import com.learn.Entities.EmployeeEntity;

public interface EmpService {

	EmployeeEntity createEmployee(EmployeeEntity entity)throws Exception;
	List<EmployeeEntity> getAllEmployee() throws Exception;

}
