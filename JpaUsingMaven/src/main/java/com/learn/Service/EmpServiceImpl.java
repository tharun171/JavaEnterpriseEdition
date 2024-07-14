package com.learn.Service;


import java.util.List;

import com.learn.Dao.EmpDao;
import com.learn.Entities.EmployeeEntity;
import com.learn.Others.Factory;

public class EmpServiceImpl implements EmpService{

private EmpDao dao;
	
	@Override
	public EmployeeEntity createEmployee(EmployeeEntity entity) throws Exception {
		EmployeeEntity savedEntity = null;
		try
		{
			dao = Factory.createEmpDao();
			savedEntity = dao.createEmployee(entity);
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return savedEntity;
	}

	@Override
	public List<EmployeeEntity> getAllEmployee() throws Exception {
		List<EmployeeEntity> list = null;
		try
		{
			dao = Factory.createEmpDao();
			list = dao.getAllEmployee();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return list;
	}

}
