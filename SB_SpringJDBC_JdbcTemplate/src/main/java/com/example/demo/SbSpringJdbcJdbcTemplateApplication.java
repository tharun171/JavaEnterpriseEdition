package com.example.demo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.demo.DAO.PersonDaoJdbc;
import com.example.demo.Entitites.Person;

//WORKING
//Data.sql contains db schema and data
//we use h2-console
//after restarting db, everything will start from data.sql


@SpringBootApplication
@ComponentScan(basePackages = "com.example.demo.*")
public class SbSpringJdbcJdbcTemplateApplication 
implements CommandLineRunner{


	@Autowired
	PersonDaoJdbc jdbcDao;
	
	//print logs
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	public static void main(String[] args) {
		SpringApplication.run(SbSpringJdbcJdbcTemplateApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		
		//log.info("All users using custom row mapper -> {}",jdbcDao.getAllUsingCustomRowMapper());
		//log.info("All users -> {}",jdbcDao.getAll());
		//log.info("get id 1002 ->{}",jdbcDao.getByid(1002));
		//log.info("get by location bng ->{}",jdbcDao.getAllById("bng"));
		//log.info("delete by id, no of rows updated->{}",jdbcDao.deleteById(1002));
		//log.info("All users -> {}",jdbcDao.getAll());
		//log.info("delete by id and name, no of rows updated->{}",jdbcDao.deleteByIdAndName(1003,"ramesh"));
		//log.info("inserting 1004 ->{}",jdbcDao.insert(new Person(1004,"lohi","bng",new Date())));
		//log.info("All users -> {}",jdbcDao.getAll());
		//based on id number only we are updating details
		//log.info("updating 1003 ->{}",jdbcDao.update(new Person(1003,"meme","bng",new Date())));
		
		log.info("All users -> {}",jdbcDao.getAll());
	
	}
}
