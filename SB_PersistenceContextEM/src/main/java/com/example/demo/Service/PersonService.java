package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entities.PersonEntity;


public interface PersonService {

	PersonEntity findById(Integer id);
	
	String addPerson(PersonEntity p);
	
	PersonEntity updateById(Integer id,String name);
	
	String deleteById(Integer id);
	
	List<PersonEntity> findAll();
}
