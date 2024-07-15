package com.learn.spring.Ui;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.learn.spring.Entities.FullTimeEmployee;
import com.learn.spring.Entities.PartTimeEmployee;
import com.learn.spring.Repositories.EmployeeRepo;

@SpringBootApplication
public class MainClass1 implements CommandLineRunner{

	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private EmployeeRepo empRepo;
	
	public static void main(String[] args) 
	{
		
	}

	@Override
	public void run(String... args) throws Exception {
		
		//save full time employee
		empRepo.saveEmployee(new FullTimeEmployee("tarun",new BigDecimal("99999")));
		//save part time employee
		empRepo.saveEmployee(new PartTimeEmployee("kumar",new BigDecimal("15000")));
		
		
		log.info("");
	}

}
