package com.example.demo.Dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.repository.cdi.Eager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.BusinessBeans.EmployeeBean;
import com.example.demo.Entities.EmployeeEntity;


@Repository
@Transactional("txManager")
public class EmployeeDaoImpl {

	@Autowired
	@Lazy
	private EmployeeDao daoRepo;
	
	public void saveEmployee(EmployeeBean bean) throws Exception {
		 try {
	            System.out.println("inside dao impl");
	            EmployeeEntity entity = new EmployeeEntity();
	            BeanUtils.copyProperties(bean, entity);
	            EmployeeEntity savedEntity = daoRepo.save(entity);
	            EmployeeBean savedDataInBean = new EmployeeBean();
	            BeanUtils.copyProperties(savedEntity, savedDataInBean);
	            System.out.println("saved details ");
	            System.out.println(savedDataInBean);
	            System.out.println("saved!!!");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}
	
	public void saveAllMethod(List<EmployeeBean> listBean)
	{
		List<EmployeeEntity> listEntity = new ArrayList<EmployeeEntity>();
		for(EmployeeBean bean:listBean)
		{
			EmployeeEntity entity = new EmployeeEntity();
			BeanUtils.copyProperties(bean,entity);
			listEntity.add(entity);
		}
		Iterable<EmployeeEntity> savedEntity = daoRepo.saveAll(listEntity);
		Iterator<EmployeeEntity> savedEntity1 = savedEntity.iterator();
		List<EmployeeEntity> savedEntities = new ArrayList<EmployeeEntity>();
		while(savedEntity1.hasNext())
		{
			savedEntities.add(savedEntity1.next());
		}
		for(EmployeeEntity var:savedEntities)
		{
			System.out.println(var.toString());
		}
	}
	
	public EmployeeBean findByIdMethod(Integer empId)
	{
		//findById() - returns entity or optional if null
		Optional<EmployeeEntity> entity = daoRepo.findById(empId);
		EmployeeEntity entity1 = entity.get();
		EmployeeBean bean = new EmployeeBean();
		BeanUtils.copyProperties(entity1, bean);
		System.out.println("id: "+empId+" "+bean);
		return bean;
	}
	
	public  Boolean existsByIdMethod(Integer empId)
	{
		//returns boolean
		Boolean res = daoRepo.existsById(empId);
		System.out.println("empid: "+empId+" exist is "+res);
		return res;
	}
	
	public List<EmployeeEntity> findAllMethod()
	{
		//findAll() get all instances
		List<EmployeeEntity> list = (List<EmployeeEntity>) daoRepo.findAll();
		for(EmployeeEntity var:list)
		{
			System.out.println(var);
		}	
		return list;
	}
	
	public List<EmployeeEntity> findAllById(List<Integer> ids)
	{
		//findAllById(list of ids) 
		List<EmployeeEntity> list = (List<EmployeeEntity>) daoRepo.findAllById(ids);
		for(EmployeeEntity var:list)
		{
			System.out.println(var);
		}	
		return list;
	}
	
	public Integer countMethod()
	{
		Integer count = (int) daoRepo.count();
		System.out.println("count of all entities "+count);
		return count;
	}
}
