package com.learn.jpa.Dao;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.learn.jpa.BusinessBeans.EmployeeBean;
import com.learn.jpa.Entities.EmployeeEntity;


@Repository
@Transactional(value = "transactionManager")
public class EmployeeDaoImpl implements EmployeeDao{
	
	@Autowired
	private EmployeeDaoRepo dao;

	public void saveEmployee(EmployeeBean employee)
	{
		System.out.println("inside dao impl - saveEmployee");
		EmployeeEntity emp = new EmployeeEntity();
		BeanUtils.copyProperties(employee, emp);
		EmployeeEntity savedEntity = dao.save(emp);
		EmployeeBean savedBean = new EmployeeBean();
		BeanUtils.copyProperties(savedEntity, savedBean);
		System.out.println("saved bean details "+savedBean);
	}

	@Override
	public List<EmployeeEntity> findAll() {
		System.out.println("inside dao impl - findAll");
		List<EmployeeEntity> list = (List<EmployeeEntity>) dao.findAll();
		return list;
	}
}
