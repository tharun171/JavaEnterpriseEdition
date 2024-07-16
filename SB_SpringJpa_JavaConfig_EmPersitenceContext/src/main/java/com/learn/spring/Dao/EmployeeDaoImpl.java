package com.learn.spring.Dao;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.learn.spring.Entities.EmployeeEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;



@Repository
@Transactional(value="transactionManager")
public class EmployeeDaoImpl implements EmployeeDao{
	
	@PersistenceContext
	private EntityManager em;
	
	public List<EmployeeEntity> findAllMethod()
	{
		List<EmployeeEntity> list = new ArrayList<EmployeeEntity>();
		//get id 1011
		System.out.println("get employee with id 1");
		EmployeeEntity empEn = em.find(EmployeeEntity.class,1);
		System.out.println("id 1 "+empEn);
		try
		{
			System.out.println("inside dao impl");
			Query q = em.createQuery("select e from EmployeeEntity e");
			list = q.getResultList();
			//for(EmployeeEntity entity:list)
			//{
			//	System.out.println(entity.toString());
			//}
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
