package com.learn.spring.Services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.learn.spring.Entities.EmployeeEntity;

public interface PagingSortingService {

EmployeeEntity saveEmployee(EmployeeEntity entity) throws Exception;
	
	List<EmployeeEntity> getAll();
	
	EmployeeEntity getById(Integer id);
	
	EmployeeEntity updateEmp(EmployeeEntity emp);
	
	String deleteById(Integer id);
	
	public Page<EmployeeEntity> getPageOfResults(int pageNum,int entriesPerPage,String sortField);

}
