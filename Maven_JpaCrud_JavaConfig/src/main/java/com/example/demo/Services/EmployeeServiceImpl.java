package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.BusinessBeans.EmployeeBean;
import com.example.demo.Dao.EmployeeDao;
import com.example.demo.Entities.EmployeeEntity;

@Service
public class EmployeeServiceImpl implements EmployeeServicee {

	@Autowired
	private EmployeeDao daoImpl;
	
	@Override
	public List<EmployeeEntity> findAllMethod() {
		// TODO Auto-generated method stub
		return daoImpl.findAllMethod();
	}

	@Override
	public String addEmployee(EmployeeBean empBean) {
		// TODO Auto-generated method stub
		return daoImpl.addEmployee(empBean);
	}

	
}
