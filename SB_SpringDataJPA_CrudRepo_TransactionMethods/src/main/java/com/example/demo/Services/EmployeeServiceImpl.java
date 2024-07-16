package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.EmployeeDaoImpl;
import com.example.demo.Entities.EmployeeEntity;

@Service
public class EmployeeServiceImpl implements EmployeeServicee {

	@Autowired
	private EmployeeDaoImpl daoImpl;
	
	@Override
	public List<EmployeeEntity> findAllMethod() {
		// TODO Auto-generated method stub
		return daoImpl.findAllMethod();
	}

	@Override
	public EmployeeEntity addMethod() {
		return daoImpl.addMethod();
	}

	@Override
	public EmployeeEntity findById(Integer empId) {
		return daoImpl.findById(empId);
	}

	
}
