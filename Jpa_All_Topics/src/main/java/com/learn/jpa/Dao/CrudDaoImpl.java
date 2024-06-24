package com.learn.jpa.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.learn.jpa.BusinessBeans.EmployeeBean;
import com.learn.jpa.Entities.EmployeeEntity;
import com.learn.jpa.Others.JpaUtilities;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;

public class CrudDaoImpl implements CrudDao{
	
	private EntityManager em;
	private EntityManagerFactory emf;

	@Override
	public void createEmployee(EmployeeBean bean) throws Exception {
		try
		{
			emf = JpaUtilities.getEmf();
			em = emf.createEntityManager();
			EmployeeEntity entity = convertBeanToEntity(bean);
			em.getTransaction().begin();
			em.persist(entity);
			System.out.println("saved!!!");
			em.getTransaction().commit();
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}

	@Override
	public EmployeeBean getEmployee(Integer empId) throws Exception {
		EmployeeBean bean = null;
		try
		{
			EntityManagerFactory emf = JpaUtilities.getEmf();
			em = emf.createEntityManager();
			EmployeeEntity entity = em.find(EmployeeEntity.class,empId);
			bean = convertEntityToBean(entity);
		}
		catch(Exception ex)
		{
			System.err.println(ex.getMessage());
		}
		return bean;
	}

	@Override
	public EmployeeBean updateEmployee(EmployeeBean bean) throws Exception {
		EmployeeBean returnBean = null;
		try
		{
			System.out.println(bean);
			EntityManagerFactory emf = JpaUtilities.getEmf();
			em = emf.createEntityManager();
			EmployeeEntity entity = convertBeanToEntity(bean);
			System.out.println(entity);
			em.getTransaction().begin();
			EmployeeEntity savedEntity = em.merge(entity);
			returnBean = convertEntityToBean(savedEntity);
			System.out.println("updated!!!");
			em.getTransaction().commit();
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return returnBean;
	}

	@Override
	public EmployeeBean deleteEmployee(Integer empId) throws Exception {
		EmployeeBean bean = null;
		try
		{
			EntityManagerFactory emf = JpaUtilities.getEmf();
			em = emf.createEntityManager();
			EmployeeEntity entity = em.find(EmployeeEntity.class,empId);
			bean = convertEntityToBean(entity);
			em.getTransaction().begin();
			em.remove(entity);
			em.getTransaction().commit();
		}
		catch(Exception ex)
		{
			System.err.println(ex.getMessage());
		}
		return bean;
	}

	@Override
	public List<EmployeeBean> getAllEmployee() throws Exception {
		List<EmployeeBean> list = null;
		try
		{
			list = new ArrayList<EmployeeBean>();
			EntityManagerFactory emf = JpaUtilities.getEmf();
			em = emf.createEntityManager();
			Query q = em.createQuery("select e from EmployeeEntity e");
			List<EmployeeEntity> listEntity = q.getResultList();
			//System.out.println(listEntity);
			for(EmployeeEntity e:listEntity)
			{
				EmployeeBean bean = convertEntityToBean(e);
				list.add(bean);
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return list;
	}
	
	public EmployeeEntity convertBeanToEntity(EmployeeBean bean)throws Exception
	{
		EmployeeEntity entity = new EmployeeEntity();
		BeanUtils.copyProperties(bean, entity);
		return entity;	
	}
	public EmployeeBean convertEntityToBean(EmployeeEntity entity)throws Exception
	{
		EmployeeBean bean = new EmployeeBean();
		BeanUtils.copyProperties(entity, bean);
		return bean;
	}

}
