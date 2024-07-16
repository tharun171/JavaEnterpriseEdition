package com.example.demo.Services;

import java.util.List;

import com.example.demo.Entities.EmployeeEntity;

public interface EmployeeService {

	List<EmployeeEntity> findAllMethod();
	Integer updateSalaryPositional(Double salary,String name);
	Integer updateSalaryNamed(Double salary,String name);
	EmployeeEntity findById(Integer empId);
	
	
	//custom method created in dao itself
	EmployeeEntity saveEmployee(EmployeeEntity entity);
	EmployeeEntity findByIdNamed(Integer id);
	EmployeeEntity findByNameDao(String name);
	
	
	List<EmployeeEntity> findBySalaryGreaterThanEqualMethod(Double salary);
	List<EmployeeEntity> findBySalaryGreaterThanEqualOrderByEmpIdDescMethod(Double salary);
	List<EmployeeEntity> findBySalaryGreaterThanEqualOrderByEmpIdMethod(Double salary);
	List<EmployeeEntity> findBySalaryBetweenMethod(Double salary1,Double salary2);
	List<EmployeeEntity> findBySalaryGreaterThanEqualAndRoleMethod(Double salary1,String name);
	List<EmployeeEntity>  findByNameContainingOrderBySalaryDescMethod(String pattern);
}
