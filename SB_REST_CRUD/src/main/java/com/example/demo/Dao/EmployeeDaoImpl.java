package com.example.demo.Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.example.demo.BusinessBeans.EmployeeBean;
import com.example.demo.Entities.EmployeeEntity;

@Repository
public class EmployeeDaoImpl {
	
	@Autowired
	@Lazy
	private EmployeeDao Repo;
	
	public Integer saveEmployee(EmployeeBean bean)throws Exception
	{
		EmployeeEntity entity = new EmployeeEntity();
		BeanUtils.copyProperties(bean, entity);
		EmployeeEntity savedEntity = Repo.save(entity);
		EmployeeBean savedBean = new EmployeeBean();
		BeanUtils.copyProperties(savedEntity, savedBean);
		System.out.println("details of saved "+savedBean.toString());
		return savedBean.getEmpId();
	}
	
	public List<EmployeeBean> getAllEmployee() throws Exception
	{
		List<EmployeeEntity> listEntity = (List<EmployeeEntity>) Repo.findAll();
		List<EmployeeBean> listBean = new ArrayList<>();
		for(EmployeeEntity e:listEntity)
		{
			EmployeeBean bean = new EmployeeBean();
			BeanUtils.copyProperties(e,bean);
			listBean.add(bean);
		}
		return listBean;
	}
	
	public EmployeeBean getEmployeeById(Integer id)
	{
		Optional<EmployeeEntity> entity = Optional.of(Repo.findById(id).orElse(new EmployeeEntity()));
		EmployeeEntity entity1 = entity.get();		
		EmployeeBean bean = new EmployeeBean();
		BeanUtils.copyProperties(entity1, bean);
		return bean;
	}
	
	public EmployeeBean updateEmployee(EmployeeBean bean)
	{
		if(bean.getEmpId() != null)
		{
			Optional<EmployeeEntity> entity = Repo.findById(bean.getEmpId());
			EmployeeEntity entity1 = entity.get();
			if(entity1.getEmpId()==0)
			{
				return new EmployeeBean();
			}
			else
			{
				System.out.println(bean);
				BeanUtils.copyProperties(bean, entity1);
				System.out.println(entity1.toString());
				EmployeeEntity savedEntity = Repo.save(entity1);
				EmployeeBean savedBean = new EmployeeBean();
				BeanUtils.copyProperties(savedEntity, savedBean);
				System.out.println(savedEntity.toString());
				return savedBean;
			}
		}
		else
		{
			return new EmployeeBean();
		}
	}
	
	public String deleteEmployeeById(Integer id)
	{
		String result = "something";
		EmployeeEntity entity = Repo.findById(id).orElse(new EmployeeEntity());
		System.out.println("entity -> "+entity.toString());
		if(entity.getEmpId() == null)
		{
			return result=id+" not available in db";
		}
		else
		{
			Repo.delete(entity);
			return result="deleted";
		}
	}
	
	public List<EmployeeBean> getEmpDetailsRange(Double min,Double max)
	{
		List<EmployeeEntity> listEntity = Repo.getEmployeeSalaryRange(min, max);
		List<EmployeeBean> listBean = new ArrayList<>();
		for(EmployeeEntity e:listEntity)
		{
			EmployeeBean bean = new EmployeeBean();
			BeanUtils.copyProperties(e,bean);
			listBean.add(bean);
		}
		return listBean;
	}

}
