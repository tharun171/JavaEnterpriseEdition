package com.example.demo.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Entities.PersonEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
@Transactional
@NamedQuery(name="findAll",
query="select * from PersonEntity")
public class PersonDao {

	//Gives connection to the database
	//EntityManager manages all the entities
	//Operations are stored in Persistence Context
	
	@PersistenceContext
	private EntityManager em;
	
	public PersonEntity findById(Integer id)
	{
		return em.find(PersonEntity.class, id);
	}
	
	public String addPerson(PersonEntity p)
	{
		em.persist(p);
		return "saved";
	}
	
	//Update = merge
	public PersonEntity updateById(Integer id,String name)
	{
		PersonEntity en = em.find(PersonEntity.class,id);
		en.setPersonName(name);
		return em.merge(en);
	}
	public String deleteById(Integer id)
	{
		PersonEntity p = em.find(PersonEntity.class, id);
		
		if(p==null)
		{
			return "entry not exist";
		}
		else
		{
			em.remove(p);
			return "removed";
		}	
	}
	
	public List<PersonEntity> findAll()
	{
		 TypedQuery<PersonEntity> query = em.createNamedQuery("findAll", PersonEntity.class);
		    List<PersonEntity> persons = query.getResultList();
		    for (PersonEntity person : persons) {
		        System.out.println(person);
		    }
		    return persons;
	}
	
}
