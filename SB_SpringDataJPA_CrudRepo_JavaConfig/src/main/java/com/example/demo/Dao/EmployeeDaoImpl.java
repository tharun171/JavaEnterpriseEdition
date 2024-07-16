package com.example.demo.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.BusinessBeans.EmployeeBean;
import com.example.demo.Entities.EmployeeEntity;

@Repository
@Transactional(value = "transactionManager")
public class EmployeeDaoImpl implements EmployeeDao{
	
	
	@Autowired
	private EmployeeDaoRepo empRepo;

	@Override
	public List<EmployeeEntity> findAllMethod() {
		List<EmployeeEntity> list = new ArrayList<EmployeeEntity>();
		try
		{
			System.out.println("inside dao impl");
			list = empRepo.findAll();
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
	public String addEmployee(EmployeeBean empBean) {
		
		EmployeeEntity entity = new EmployeeEntity();
		BeanUtils.copyProperties(empBean, entity);
		empRepo.save(entity);
		System.out.println(entity.toString());
		return "saved";
	}
	
	

	
}
