package com.learn.Dao;

import java.util.List;

import com.learn.Entities.EmployeeEntity;

public interface EmpDao {

	EmployeeEntity createEmployee(EmployeeEntity entity)throws Exception;
	List<EmployeeEntity> getAllEmployee() throws Exception;

}
