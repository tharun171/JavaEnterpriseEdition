package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.PersonDao;
import com.example.demo.Entities.PersonEntity;

@Service
public class PersonServiceImpl implements PersonService
{

	@Autowired
	PersonDao dao;
	
	public PersonEntity findById(Integer id)
	{
		return dao.findById(id);
	}

	@Override
	public String addPerson(PersonEntity p) {
		return dao.addPerson(p);
	}

	@Override
	public PersonEntity updateById(Integer id, String name) {
		return dao.updateById(id,name);
	}

	@Override
	public String deleteById(Integer id) {
		
		return dao.deleteById(id);
	}

	@Override
	public List<PersonEntity> findAll() {
		return dao.findAll();
	}
}
