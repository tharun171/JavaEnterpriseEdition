package com.learn.spring.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.spring.Entities.EmployeeEntity;
import com.learn.spring.ProjectDao.CrudRepoDao;

@Service
public class CrudRepoServiceImpl implements CrudRepoService {

	@Autowired
	private CrudRepoDao crudRepo;

	@Override
	public EmployeeEntity saveEmployee(EmployeeEntity emp) {
		System.out.println("before saving "+emp);
		EmployeeEntity savedEntity = crudRepo.save(emp);
		System.out.println("after saving "+savedEntity);
		return savedEntity;
	}
	
	@Override
	public List<EmployeeEntity> getAll() {
		System.out.println("inside service");
		List<EmployeeEntity> list = (List<EmployeeEntity>) crudRepo.findAll();
		return list;
	}

	@Override
	public EmployeeEntity getById(Integer id) {
		System.out.println("inside service");
		//EmployeeEntity savedEntity = crudRepo.getById(id);
		Optional<EmployeeEntity> Entity = crudRepo.findById(id);
		EmployeeEntity savedEntity = null;
		if(Entity.isPresent()==true)
		{
			savedEntity = Entity.get();
		}
		else
		{
			savedEntity = new EmployeeEntity();
		}
		return savedEntity;
	}

	@Override
	public String deleteById(Integer id) {
		Optional<EmployeeEntity> Entity = crudRepo.findById(id);
		System.out.println(Entity);
		System.out.println(Entity.isPresent());
		String res;
		if(Entity.isPresent()==false)
		{
			res = "wrong id";
		}
		else
		{
			EmployeeEntity savedEntity = Entity.get();
			System.out.println(savedEntity);
			System.out.println(savedEntity.getEmpId());
			crudRepo.delete(savedEntity);
			res = "deleted";
		}
			
		return res;
	}

	@Override
	public EmployeeEntity updateEmp(EmployeeEntity emp) {
		
		//Optional<EmployeeEntity> entity = crudRepo.findById(emp.getEmpId());
		EmployeeEntity saved = crudRepo.save(emp);
		return saved;
	}
}
