package com.learn.jpa.Dao;

import java.util.List;

import com.learn.jpa.BusinessBeans.EmployeeBean;
import com.learn.jpa.Entities.EmployeeEntity;


public interface EmployeeDao {

	void saveEmployee(EmployeeBean bean);
	
	List<EmployeeEntity> findAll();
}
