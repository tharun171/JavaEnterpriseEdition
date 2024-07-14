package com.learn.orm.Dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.learn.orm.BusinessBeans.EmployeeBean;
import com.learn.orm.Entities.EmployeeEntity;
import com.learn.orm.Others.JpaUtility;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class EmployeeDaoImpl implements EmployeeDao{

	private EntityManager em;
	private EntityManagerFactory emf;
	

	public List<Object> stringFucntionsDemo() {
		
		emf=Persistence.createEntityManagerFactory("unit2");
		em = emf.createEntityManager();
		
		Query query = em.createQuery("select e.employeeName,UPPER(e.employeeName),LOWER(e.employeeName),"
				+ "SUBSTRING(e.employeeName,1,3),LENGTH(e.employeeName) from EmployeeEntity e");
		List<Object> list  = query.getResultList();
		
		em.close();
		emf.close();
		return list;
	}

	public List<Object> dateFunctionsDemo() {
		emf = Persistence.createEntityManagerFactory("unit2");
		em = emf.createEntityManager();
		
		Query query = em.createQuery("select e.insertTime,YEAR(e.insertTime),MONTH(e.insertTime),"
				+ "DAY(e.insertTime) from EmployeeEntity e");
		List<Object> list = query.getResultList();
		
		em.close();
		emf.close();
		return list;
	}

	@Override
	public List<Object> MathFunctions() {
		emf = Persistence.createEntityManagerFactory("unit2");
		em = emf.createEntityManager();
		Query q = em.createQuery("select avg(e.Salary),sum(e.Salary),count(e.Salary),max(e.Salary),min(e.Salary) from EmployeeEntity e");
		List<Object> list = q.getResultList();
		em.close();
		emf.close();
		return list;
	}
	
	@Override
	public int insertEmployee(EmployeeBean bean) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("inside dao class");
		EmployeeEntity entity = new EmployeeEntity();
		BeanUtils.copyProperties(bean, entity);
		emf = JpaUtility.getEmf();
		em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
		return 1;
	}

	@Override
	public EmployeeBean updateSalaryOfEmployeeWithNameAs(String name, double salary) {
		// TODO Auto-generated method stub
		emf = Persistence.createEntityManagerFactory("unit2");
		em = emf.createEntityManager();
		em.getTransaction().begin();
		EmployeeEntity modifiedEntity = new EmployeeEntity();
		//names are from EmployeeEntity
		Query query = em.createQuery("update EmployeeEntity e set e.Salary=?1 where e.employeeName=:key");
		query.setParameter(1,salary);
		query.setParameter("key",name);
		Integer noOfRowsUpdated = query.executeUpdate();
		System.out.println("no of rows affected "+noOfRowsUpdated);
		Query query1 = em.createQuery("select e from EmployeeEntity e where e.employeeName=:keyName");
		query1.setParameter("keyName",name);
		modifiedEntity = (EmployeeEntity) query1.getSingleResult();
		System.out.println("modified entity "+modifiedEntity);
		EmployeeBean modifiedBean  = new EmployeeBean();
		BeanUtils.copyProperties(modifiedEntity,modifiedBean);
		em.getTransaction().commit();
		return modifiedBean;
	}

	@Override
	public EmployeeBean getEmployeeById(int id) {
		// TODO Auto-generated method stub
		emf = Persistence.createEntityManagerFactory("unit2");
		em = emf.createEntityManager();
		em.getTransaction().begin();
		EmployeeEntity Entity = new EmployeeEntity();
		Query query1 = em.createQuery("select e from EmployeeEntity e where e.employeeId=:keyId");
		query1.setParameter("keyId",id);
		Entity = (EmployeeEntity) query1.getSingleResult();
		System.out.println("modified entity "+Entity);
		EmployeeBean Bean  = new EmployeeBean();
		BeanUtils.copyProperties(Entity,Bean);
		em.getTransaction().commit();
		return Bean;
	}

	@Override
	public List<EmployeeBean> salaryInRange(double salary1, double salary2) {
		// TODO Auto-generated method stub
		emf = Persistence.createEntityManagerFactory("unit2");
		em = emf.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createNamedQuery("query1");
		query.setParameter(1,salary1);
		query.setParameter(2,salary2);
		List<EmployeeEntity> entityList = query.getResultList();
		em.getTransaction().commit();
		List<EmployeeBean> listBean = new ArrayList<EmployeeBean>();
		for(EmployeeEntity entity:entityList)
		{
			EmployeeBean bean = new EmployeeBean();
			BeanUtils.copyProperties(entity,bean);
			System.out.println(bean.toString());
			listBean.add(bean);
		}
		return listBean;
	}

	@Override
	public List<EmployeeBean> NameLikeSubstringSalaryDesc(String subString) {
		// TODO Auto-generated method stub
		emf = Persistence.createEntityManagerFactory("unit2");
		em = emf.createEntityManager();
		em.getTransaction().begin();
		System.out.println(subString);
		Query query = em.createNamedQuery("query2");
		//when given chars to find as substring like mes in ramesh
		query.setParameter("subStr","%"+subString+"%");
		//when given full name
		//query.setParameter("subStr",subString);
		List<EmployeeEntity> entityList = query.getResultList();
		System.out.println(entityList);
		em.getTransaction().commit();
		List<EmployeeBean> listBean = new ArrayList<EmployeeBean>();
		for(EmployeeEntity entity:entityList)
		{
			EmployeeBean bean = new EmployeeBean();
			BeanUtils.copyProperties(entity,bean);
			System.out.println(bean.toString());
			listBean.add(bean);
		}
		return listBean;
	}

	@Override
	public List<EmployeeEntity> findEmpByNameAndRolePositionalParam(String name, String role) {
		// TODO Auto-generated method stub
		emf = Persistence.createEntityManagerFactory("unit2");
		em = emf.createEntityManager();
		Query q = em.createNamedQuery("findEmpByNameAndRolePositional",EmployeeEntity.class);
		q.setParameter(1,name);
		q.setParameter(2,role);
		List<EmployeeEntity> returnEntity = q.getResultList();
		Iterator<EmployeeEntity> itr = returnEntity.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next().toString());
		}
		return returnEntity;
	}

	@Override
	public List<EmployeeEntity> findEmpByNameNamedParam(String name) {
		// TODO Auto-generated method stub
		emf = Persistence.createEntityManagerFactory("unit2");
		em = emf.createEntityManager();
	Query q =em.createNamedQuery("findEmpByNameNamed",EmployeeEntity.class);
	//name is field given in orm.xml
	q.setParameter("name",name);
		List<EmployeeEntity> returnEntity = q.getResultList();
		Iterator<EmployeeEntity> itr = returnEntity.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next().toString());
		}
		return returnEntity;
	}

	@Override
	public List<EmployeeEntity> findAllEmpFromXML() {
		// TODO Auto-generated method stub
		emf = Persistence.createEntityManagerFactory("unit2");
		em = emf.createEntityManager();
		Query q = em.createNamedQuery("findAllEmp",EmployeeEntity.class);
		List<EmployeeEntity> returnEntity = q.getResultList();
		Iterator<EmployeeEntity> itr = returnEntity.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next().toString());
		}
		return returnEntity;
	}
	
	
public List<EmployeeBean> getEmployeeDetailsUsingHibernateProvider() {
		
		emf = Persistence.createEntityManagerFactory("unit2");
		em = emf.createEntityManager();
		
		//hibernate query -> the above used one is jpql query
		Query query = em.createQuery("from EmployeeEntity");
		List<EmployeeEntity> listEntity = query.getResultList();
		List<EmployeeBean> listBean = new ArrayList<>();
		for(EmployeeEntity e:listEntity)
		{
			EmployeeBean bean = new EmployeeBean();
			BeanUtils.copyProperties(e,bean);
			listBean.add(bean);
		}
		em.close();
		emf.close();
		return listBean;
	}
}
