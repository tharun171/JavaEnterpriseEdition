package com.learn.jpa.Dao;

import java.util.List;

import com.learn.jpa.Others.JpaUtilities;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;

public class JpaFunctionsDaoImpl implements JpaFunctionsDao{

	private EntityManager em = null;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> StringFunctionsDemo() throws Exception {
		List<Object> list = null;
		try
		{
			EntityManagerFactory emf = JpaUtilities.getEmf();
			em = emf.createEntityManager();
			//empName id the name in entity not in DB
			//all we use is entity names in writing queries
			Query query = em.createQuery(
					"select e.empName,UPPER(e.empName),lower(e.empName),"
					+ "SUBSTRING(e.empName,1,3),LENGTH(e.empName) "
					+ "from EmployeeEntity e");
			list = query.getResultList();			
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> dateFunctionsDemo() throws Exception {
		List<Object> list = null;
		try
		{
			EntityManagerFactory emf = JpaUtilities.getEmf();
			em = emf.createEntityManager();
			Query q = em.createQuery("select k.joiningdate,YEAR(k.joiningdate),"
					+ "MONTH(k.joiningdate),DAY(k.joiningdate)"
					+ " from EmployeeEntity k");
			list = q.getResultList();
		}
		catch(Exception ex)
		{
			System.out.println(ex.getLocalizedMessage());
		}
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> MathFunctionsDemo() throws Exception {
		List<Object> list = null;
		try
		{
			EntityManagerFactory emf = JpaUtilities.getEmf();
			em = emf.createEntityManager();
			Query query = em.createQuery(
					"select j.salary,avg(j.salary),max(j.salary),"+
			"min(j.salary),count(j.salary),sum(j.salary)"
					+ "from EmployeeEntity j");
			list = query.getResultList();
		}
		catch(Exception ex)
		{
			System.out.println(ex.getLocalizedMessage());
		}
		return list;
	}

}
