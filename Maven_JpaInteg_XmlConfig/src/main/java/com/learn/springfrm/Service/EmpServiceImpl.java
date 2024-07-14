package com.learn.springfrm.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.springfrm.Dao.EmpDao;
import com.learn.springfrm.Entities.EmployeeEntity;

@Service
public class EmpServiceImpl implements EmpService{

	@Autowired
	private EmpDao empDao;

	@Override
	public String saveEmployee(EmployeeEntity emp) {
		System.out.println("insdie service Impl");
		return empDao.saveEmployee(emp);
	}

	@Override
	public EmployeeEntity findEmployee(Integer empId) {
		return empDao.findEmployee(empId);
	}

	@Override
	public List<EmployeeEntity> findAll() {
		// TODO Auto-generated method stub
		return empDao.findAll();
	}

	
}
