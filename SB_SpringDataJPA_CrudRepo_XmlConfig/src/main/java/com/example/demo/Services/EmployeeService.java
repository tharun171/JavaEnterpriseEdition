package com.example.demo.Services;

import java.util.List;

import com.example.demo.BusinessBeans.EmployeeBean;
import com.example.demo.Entities.EmployeeEntity;

public interface EmployeeService {

void saveEmployee(EmployeeBean bean)throws Exception;
	
	void saveAllMethod(List<EmployeeBean> listBean);
	
	EmployeeBean findByIdMethod(Integer empId);	//findById() - returns entity or optional if null
	
	Boolean existsByIdMethod(Integer empId);		//returns boolean 
	
	List<EmployeeEntity> findAllMethod();		//findAll() get all instances
	
	List<EmployeeEntity> findAllById(List<Integer> ids);
	
	Integer countMethod();
}
