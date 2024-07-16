package com.example.demo.Dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.BusinessBeans.EmployeeBean;
import com.example.demo.Entities.EmployeeEntity;
import com.example.demo.Services.EmployeeServicee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{
	
	@Autowired
	private EmployeeDaoRepo empRepo;
	
	//Each method will have individual Transaction
	
	@Transactional(value="transactionManager")
	@Override
	public List<EmployeeEntity> findAllMethod() {
		List<EmployeeEntity> list = new ArrayList<EmployeeEntity>();
		list = empRepo.findAll();
		for(EmployeeEntity entity:list)
		{
			System.out.println(entity.toString());
		}
		return list;
	}

	@Transactional(value="transactionManager",
			readOnly = true)
	@Override
	public EmployeeEntity addMethod() {
		EmployeeEntity entity = new EmployeeEntity(null,"koko","manager",new Date(),123456.30);
		EmployeeEntity resultEntity = empRepo.save(entity);
		/*
		 12:42:44.465 [main] DEBUG org.hibernate.engine.jdbc.spi.SqlExceptionHelper - could not execute statement [n/a]
		 java.sql.SQLException: Connection is read-only. Queries leading to data modification are not allowed
		 */
		System.out.println(resultEntity);
		return resultEntity;
	}

	@Transactional(value = "transactionManager",
			timeout = 3)//in seconds
	@Override
	public EmployeeEntity findById(Integer empId) {
		EmployeeEntity entity = new EmployeeEntity();
		try {
			Thread.sleep(5000);	//waits for 5 seconds
			entity = empRepo.getById(empId);
			System.out.println(entity.toString());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return entity;
	}
	
	
	
	
	

	
}
