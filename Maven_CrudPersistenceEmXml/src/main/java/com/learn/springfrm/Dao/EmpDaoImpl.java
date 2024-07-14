package com.learn.springfrm.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.learn.springfrm.Entities.EmployeeEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;


@Repository
@Transactional
public class EmpDaoImpl implements EmpDao{

	@PersistenceContext
	private EntityManager em;

	@Override
	public String saveEmployee(EmployeeEntity emp) {
		System.out.println("inside dao impl");
		//em.persist() - throwing detached entity passed to persist
		em.merge(emp);	//returns void
		return "saved";
		
	}

	@Override
	public EmployeeEntity findEmployee(Integer empId) {
		EmployeeEntity entity = null;
		try
		{
			entity = em.find(EmployeeEntity.class,empId);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return entity;
	}

	@Override
	public List<EmployeeEntity> findAll() 
	{
		TypedQuery<EmployeeEntity> q = em.createQuery("select e from EmployeeEntity e",EmployeeEntity.class);
		List<EmployeeEntity> list = q.getResultList();
		return list;
	}
}
