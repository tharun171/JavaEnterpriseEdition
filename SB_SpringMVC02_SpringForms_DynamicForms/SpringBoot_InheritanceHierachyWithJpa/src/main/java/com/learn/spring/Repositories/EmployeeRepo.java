package com.learn.spring.Repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learn.spring.Entities.Employee;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EmployeeRepo {
	
	
	@Autowired
	private EntityManager em;
	
	
	public void saveEmployee(Employee emp)
	{
		em.persist(emp);
		System.out.println("saved employee");
	}
	
	//get all employee
	public List<Employee> getAll()
	{
		//Employee is the entity name
		return em.createQuery("select e from Employee e",Employee.class)
				.getResultList();
	}

}
