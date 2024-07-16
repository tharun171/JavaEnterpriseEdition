package com.learn.spring.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.spring.Dao.EmployeeDao;
import com.learn.spring.Dao.EmployeeDaoImpl;
import com.learn.spring.Entities.EmployeeEntity;


@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	private EmployeeDao daoImpl;
	
	@Override
	public List<EmployeeEntity> findAllMethod() {
		// TODO Auto-generated method stub
		return daoImpl.findAllMethod();
	}

}
