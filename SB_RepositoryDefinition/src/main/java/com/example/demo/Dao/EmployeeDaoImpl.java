package com.example.demo.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Entities.EmployeeEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository
@Transactional(value="txManager")
public class EmployeeDaoImpl implements EmployeeDao{

	
	@Autowired
	private EmployeeDaoRepDef empRepo;
	
	@PersistenceContext
	private EntityManager em;
	
	public List<EmployeeEntity> findAllMethod()
	{
		System.out.println("inside dao impl");
		System.out.println("inside findAll method");
		List<EmployeeEntity> list = new ArrayList<EmployeeEntity>();
		try
		{
			//list = empRepo.findAll();
			//	or
			//This below is from orm.xml
			Query query = em.createNamedQuery("findAllEmployee");
			list = query.getResultList();
			for(EmployeeEntity entity:list)
			{
				System.out.println(entity.toString());
			}
		}
		catch(Exception ex)
		{
			ex.getCause();
			ex.getLocalizedMessage();
			ex.getMessage();
			System.err.println(ex.getMessage());
		}
		return list;
	}

	@Override
	public List<EmployeeEntity> findEmployeeSalaryGreaterThan(Double salary) {
		System.out.println("inside dao impl");
		System.out.println("inside findEmployeeSalaryGreaterThan");
		List<EmployeeEntity> list = new ArrayList<EmployeeEntity>();
		try
		{
			list = empRepo.findEmployeeWhoseSalaryGreaterThan(salary);
			for(EmployeeEntity entity:list)
			{
				System.out.println(entity.toString());
			}
		}
		catch(Exception ex)
		{
			ex.getCause();
			ex.getLocalizedMessage();
			ex.getMessage();
			System.err.println(ex.getMessage());
		}
		return list;
	}

	@Override
	public List<EmployeeEntity> findEmployeeSalaryGreaterThanNamed(Double salary) {
		System.out.println("inside dao impl");
		System.out.println("inside findEmployeeSalaryGreaterThanNamed");
		List<EmployeeEntity> list = new ArrayList<EmployeeEntity>();
		try
		{
			list = empRepo.findEmployeeWhoseSalaryGreaterThanNamed(salary);
			for(EmployeeEntity entity:list)
			{
				System.out.println(entity.toString());
			}
		}
		catch(Exception ex)
		{
			ex.getCause();
			ex.getLocalizedMessage();
			ex.getMessage();
			System.err.println(ex.getMessage());
		}
		return list;
	}
}
