package com.example.demo.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.Entities.EmployeeEntity;

public interface EmployeeDao extends CrudRepository<EmployeeEntity
,Integer>{

	//Spring Data JPA
	//This is Positional Parameter ?
	//Positional Parameter ordinal starts with 1
	@Query("select e from EmployeeEntity e where e.salary>=?1 and e.salary<=?2")
	public List<EmployeeEntity> getEmployeeSalaryRange(Double min,Double max);
	

}
