package com.learn.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.learn.Entities.EmployeeEntity;
import com.learn.Others.JpaUtility;

public class DaoImpl implements EmpDao{


	private EntityManagerFactory emf;
	private EntityManager em;

	@Override
	public EmployeeEntity createEmployee(EmployeeEntity entity) throws Exception {
		EmployeeEntity savedEntity = null;
		try
		{
			System.out.println("inside dao impl");
			emf = JpaUtility.getEmf();
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(entity);
			savedEntity = em.find(EmployeeEntity.class,1);
			em.getTransaction().commit();
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
			emf = JpaUtility.getEmf();
			em = emf.createEntityManager();
			//entity class name not database table name
			Query q = em.createQuery("select e from EmployeeEntity e");
			list = q.getResultList();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return list;
	}
}
