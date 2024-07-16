package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.EmployeeDaoImpl;
import com.example.demo.Entities.EmployeeEntity;


@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDaoImpl daoImpl;
	
	@Override
	public List<EmployeeEntity> findAllMethod() {
		
		return daoImpl.findAllMethod();
	}

	@Override
	public Integer updateSalaryPositional(Double salary, String name) {
		return daoImpl.updateSalaryPositional(salary,name);
	}

	@Override
	public Integer updateSalaryNamed(Double salary, String name) {
		
		return daoImpl.updateSalaryNamed(salary,name);
	}

	@Override
	public EmployeeEntity findById(Integer empId) {
		return daoImpl.findById(empId);
	}
	
	//CuSTOM methods by dao itself
	//not created using named query in orm.xml

	@Override
	public EmployeeEntity saveEmployee(EmployeeEntity entity) {
		
		return daoImpl.saveEmployee(entity);
	}

	@Override
	public EmployeeEntity findByIdNamed(Integer id) {
		
		return daoImpl.findByIdNamed(id);
	}


	@Override
	public EmployeeEntity findByNameDao(String name) {
		
		return daoImpl.findByNameDao(name);
	}

	@Override
	public List<EmployeeEntity> findBySalaryGreaterThanEqualMethod(Double salary) {
		return daoImpl.findBySalaryGreaterThanEqualMethod(salary);
	}

	@Override
	public List<EmployeeEntity> findBySalaryGreaterThanEqualOrderByEmpIdDescMethod(Double salary) {
		return daoImpl.findBySalaryGreaterThanEqualOrderByEmpIdDescMethod(salary);
	}

	@Override
	public List<EmployeeEntity> findBySalaryGreaterThanEqualOrderByEmpIdMethod(Double salary) {
		return daoImpl.findBySalaryGreaterThanEqualOrderByEmpIdMethod(salary);
	}

	@Override
	public List<EmployeeEntity> findBySalaryBetweenMethod(Double salary1, Double salary2) {
		return daoImpl.findBySalaryBetweenMethod(salary1, salary2);
	}

	@Override
	public List<EmployeeEntity> findBySalaryGreaterThanEqualAndRoleMethod(Double salary1, String name) {
		return daoImpl.findBySalaryGreaterThanEqualAndRoleMethod(salary1, name);
	}

	@Override
	public List<EmployeeEntity> findByNameContainingOrderBySalaryDescMethod(String pattern) {
		return daoImpl.findByNameContainingOrderBySalaryDescMethod(pattern);
	}
}
