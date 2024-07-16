package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import com.example.demo.Entities.PersonEntity;
import com.example.demo.Entities.PersonEntity;
import com.example.demo.Service.PersonService;


//WORKING
@SpringBootApplication
@EntityScan(basePackages = "com.example.demo.Entities")
@ComponentScan(basePackages = "com.example.demo.*")
public class SbPersistenceContextEmApplication 
implements CommandLineRunner{
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonService service;
	
	public static void main(String[] args) {
		SpringApplication.run(SbPersistenceContextEmApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		//log.info("add person -> {}",service.addPerson(new PersonEntity(null,"ramesh",456789.9)));

		//log.info("find by id -> {}",service.findById(1));
		
		//log.info("update by id -> {}",service.updateById(3,"revi"));
		
		//log.info("delete by id -> {}",service.deleteById(2));
		
		//Named Query find all
		log.info("find all-> {}",service.findAll());
	}

}
