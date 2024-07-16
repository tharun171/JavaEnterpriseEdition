package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.EmployeeDaoImpl;
import com.example.demo.Entities.EmployeeEntity;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	
	@Autowired
	private EmployeeDaoImpl daoImpl;
	
	@Override
	public List<EmployeeEntity> findAllMethod() {
		return daoImpl.findAllMethod();
	}

	@Override
	public List<EmployeeEntity> findEmployeeSalaryGreaterThan(Double salary) {
		return daoImpl.findEmployeeSalaryGreaterThan(salary);
	}

	@Override
	public List<EmployeeEntity> findEmployeeSalaryGreaterThanNamed(Double salary) {
		return daoImpl.findEmployeeSalaryGreaterThanNamed(salary);
	}

}
