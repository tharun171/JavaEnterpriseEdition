package com.learn.spring.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.learn.spring.Entities.EmployeeEntity;
import com.learn.spring.ProjectDao.PagingSortingDao;

@Service
public class PagingSortingServiceImpl implements PagingSortingService{

	@Autowired
	private PagingSortingDao dao;

	@Override
	public EmployeeEntity saveEmployee(EmployeeEntity entity) throws Exception {
		System.out.println("inside service");
		EmployeeEntity savedEntity = dao.save(entity);
		return savedEntity;
	}

	@Override
	public List<EmployeeEntity> getAll() {
		System.out.println("inside service");
		List<EmployeeEntity> list = dao.findAll();
		return list;
	}

	@Override
	public EmployeeEntity getById(Integer id) {
		System.out.println("inside service");
		//EmployeeEntity savedEntity = dao.getById(id);
		Optional<EmployeeEntity> Entity = dao.findById(id);
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
		Optional<EmployeeEntity> Entity = dao.findById(id);
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
			dao.delete(savedEntity);
			res = "deleted";
		}
			
		return res;
	}

	@Override
	public EmployeeEntity updateEmp(EmployeeEntity emp) {
		
		//Optional<EmployeeEntity> entity = dao.findById(emp.getEmpId());
		EmployeeEntity saved = dao.save(emp);
		return saved;
	}
	
	
	public Page<EmployeeEntity> getPageOfResults(int pageNum,int entriesPerPage,String sortField)
	{
		//creating a pageRequest with sorting
		//public Page<YourEntity> getPageOfResults(int pageNumber, int pageSize, String sortBy) {
		//PageRequest pageRequest = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));

		
		//sorted by empId - name we took from EmployeeEntity name
		PageRequest pr = PageRequest.of(pageNum,entriesPerPage,Sort.by(sortField));
		//Retrieving a page of results
		//pr is pageable datatype
		Page<EmployeeEntity> pages =  dao.findAll(pr);
		for(EmployeeEntity var:pages)
		{
			System.out.println(var.toString());
		}
		return dao.findAll(pr);
	}
}
