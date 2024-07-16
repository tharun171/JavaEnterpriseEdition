package com.example.demo.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Entities.EmployeeEntity;
import com.example.demo.Services.EmployeeService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository
@Transactional(value="txManager")
public class EmployeeDaoImpl implements EmployeeService{

	@Autowired
	@Lazy
	private EmployeeDao empRepo;
	
	@PersistenceContext
	private EntityManager em;
	
	//	-----------------------------------------------------
	public EmployeeEntity findById(Integer empId)
	{
		System.out.println("findById method");
		EmployeeEntity entity = empRepo.findByempId(empId);
		System.out.println("empId with details ->"+entity.toString());
		return entity;
	}
	
	public Integer updateSalaryNamed(Double salary,String name)
	{
		System.out.println("inside - updateSalaryNamed");
		int noOfRowsUpdated = 0;
		Query query = em.createNamedQuery("updateSalaryNamed");
		query.setParameter("empSalary",salary);
		query.setParameter("empName",name);
		noOfRowsUpdated = query.executeUpdate();
		System.out.println("no of rows updated "+noOfRowsUpdated);
		return noOfRowsUpdated;
	}
	
	public Integer updateSalaryPositional(Double salary,String name)
	{
		System.out.println("inside - updateSalaryPositional");
		int noOfRowsUpdated = 0;
		Query query = em.createNamedQuery("updateSalaryPositional");
		query.setParameter(1,salary);
		query.setParameter(2,name);
		noOfRowsUpdated = query.executeUpdate();
		System.out.println("no of rows updated "+noOfRowsUpdated);
		return noOfRowsUpdated;
	}
	
	public EmployeeEntity findByIdNamed(Integer id)
	{
		System.out.println("inside - findByIdNamed");
		Query query = em.createNamedQuery("findByIdOrmXml");
		query.setParameter("id",id);
		EmployeeEntity entity = (EmployeeEntity) query.getResultList().get(0);
		System.out.println(entity.toString());
		return entity;
	}
	
	public List<EmployeeEntity> findAllMethod()
	{
		List<EmployeeEntity> list = new ArrayList<EmployeeEntity>();
		System.out.println("inside - findAllMethod uses findAllHQL - from orm.xml");
		list = empRepo.findAllHQL();
		for(EmployeeEntity var:list)
		{
			System.out.println(var.toString());
		}
		return list;
	}
	
	
	//	----------------------------------------------------
	//	----------------------------------------------------
	
	public EmployeeEntity saveEmployee(EmployeeEntity entity)
	{
		EmployeeEntity returnEntity = empRepo.save(entity);
		System.out.println("return entity "+returnEntity);
		return returnEntity;
	}
	
	
	public List<EmployeeEntity> getAllMethod1()
	{
		List<EmployeeEntity> list = empRepo.findAll();
		for(EmployeeEntity var:list)
		{
			System.out.println(var.toString());
		}
		return list;
	}
	public EmployeeEntity findByNameDao(String name)
	{
		EmployeeEntity returnEntity = empRepo.findByName(name);
		System.out.println("name details: "+name+" "+returnEntity);
		return returnEntity;
	}


	@Override
	public List<EmployeeEntity> findBySalaryGreaterThanEqualMethod(Double salary) {
		List<EmployeeEntity> list = empRepo.findBySalaryGreaterThanEqual(salary);
		for(EmployeeEntity var:list)
		{
			System.out.println(var.toString());
		}
		return list;
	}

	@Override
	public List<EmployeeEntity> findBySalaryGreaterThanEqualOrderByEmpIdDescMethod(Double salary) {
		List<EmployeeEntity> list = empRepo.findBySalaryGreaterThanEqualOrderByEmpIdDesc(salary);
		for(EmployeeEntity var:list)
		{
			System.out.println(var.toString());
		}
		return list;
	}

	@Override
	public List<EmployeeEntity> findBySalaryGreaterThanEqualOrderByEmpIdMethod(Double salary) {
		List<EmployeeEntity> list = empRepo.findBySalaryGreaterThanEqualOrderByEmpId(salary);
		for(EmployeeEntity var:list)
		{
			System.out.println(var.toString());
		}
		return list;
	}

	@Override
	public List<EmployeeEntity> findBySalaryBetweenMethod(Double salary1, Double salary2) {
		List<EmployeeEntity> list = empRepo.findBySalaryBetween(salary1,salary2);
		for(EmployeeEntity var:list)
		{
			System.out.println(var.toString());
		}
		return list;
	}

	@Override
	public List<EmployeeEntity> findBySalaryGreaterThanEqualAndRoleMethod(Double salary1, String name) {
		List<EmployeeEntity> list = empRepo.findBySalaryGreaterThanEqualAndRole(salary1,name);
		for(EmployeeEntity var:list)
		{
			System.out.println(var.toString());
		}
		return list;
	}

	@Override
	public List<EmployeeEntity> findByNameContainingOrderBySalaryDescMethod(String pattern) {
		List<EmployeeEntity> list = empRepo.findByNameContainingOrderBySalaryDesc(pattern);
		for(EmployeeEntity var:list)
		{
			System.out.println(var.toString());
		}
		return list;
	}
	
}
