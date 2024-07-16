package com.example.demo;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.Entities.EmployeeEntity;
import com.example.demo.Services.EmployeeService;
import com.example.demo.Services.EmployeeServiceImpl;
import com.example.demo.resources.MainConfig;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SbRepositoryDefinitionModifyingAnnotationApplication {

	
	private static EmployeeService empService;
	
	private static final Logger log = LoggerFactory.getLogger(SbRepositoryDefinitionModifyingAnnotationApplication.class);
	
	public static void main(String[] args) {
		//SpringApplication.run(SbRepositoryDefinitionModifyingAnnotationApplication.class, args);
	
		ApplicationContext ac = new AnnotationConfigApplicationContext(MainConfig.class);
		empService = ac.getBean(EmployeeServiceImpl.class);
		
		//Query in orm.xml
		findAllHQL();
		//updateSalaryNamed(123456.6,"revi");
		//updateSalaryPositional(654321.1,"lulu");
		//findByIdNamed(1);
		
		//------------------ Custom methods created using dao
		//Repository Custom methods
		//saveEmployee();
		//findById(5);
		
		//findBySalaryGreaterThanEqualMethod(5000000.0);
		//findBySalaryGreaterThanEqualOrderByEmpIdDescMethod(5000000.0);
		//findBySalaryGreaterThanEqualOrderByEmpIdMethod(200000.0);
		//findBySalaryBetweenMethod(200000.0,700000.0);
		//findBySalaryGreaterThanEqualAndRoleMethod(100000.0,"developer");
		
		//name containing "aru" and order by salary desc 
		//findByNameContainingOrderBySalaryDescMethod("evi");
		
		((AnnotationConfigApplicationContext)ac).close();
	}

	//	---------------------ORM.xml -------------------
	public static List<EmployeeEntity> findAllHQL()
	{
		log.info("result ->{}"+empService.findAllMethod());
		return empService.findAllMethod();
	}
	
	public static Integer updateSalaryNamed(Double salary,String name)
	{
		Integer noOfRowsUpdated = empService.updateSalaryNamed(salary, name);
		System.out.println("no of rows updated "+noOfRowsUpdated);
		return noOfRowsUpdated;
	}
	
	public static Integer updateSalaryPositional(Double salary,String name)
	{
		Integer noOfRowsUpdated = empService.updateSalaryPositional(salary, name);
		System.out.println("no of rows updated "+noOfRowsUpdated);
		return noOfRowsUpdated;
	}
	public static EmployeeEntity findByIdNamed(Integer empId)
	{
		return empService.findByIdNamed(empId);
	}
	
	//	----------------------------------
	public static EmployeeEntity saveEmployee()
	{
		EmployeeEntity entity = new EmployeeEntity(null,"striff","tester",new Date(),456321.23);
		return empService.saveEmployee(entity);
	}
	public static EmployeeEntity findById(Integer empId)
	{
		return empService.findById(empId);
	}
	
	//	---------------------------------------------
	public static List<EmployeeEntity> findBySalaryGreaterThanEqualOrderByEmpIdDescMethod(Double salary)
	{
		return empService.findBySalaryGreaterThanEqualOrderByEmpIdDescMethod(salary);
	}
	public static List<EmployeeEntity> findBySalaryGreaterThanEqualMethod(Double salary)
	{
		return empService.findBySalaryGreaterThanEqualMethod(salary);
	}
	
	public static List<EmployeeEntity> findBySalaryGreaterThanEqualOrderByEmpIdMethod(Double salary)
	{
		return empService.findBySalaryGreaterThanEqualOrderByEmpIdMethod(salary);
	}
	
	public static List<EmployeeEntity> findBySalaryBetweenMethod(Double salary1,Double salary2)
	{
		return empService.findBySalaryBetweenMethod(salary1,salary2);
	}
	
	public static List<EmployeeEntity> findBySalaryGreaterThanEqualAndRoleMethod(Double salary1,String name)
	{
		return empService.findBySalaryGreaterThanEqualAndRoleMethod(salary1,name);
	}
	
	
	public static List<EmployeeEntity> findByNameContainingOrderBySalaryDescMethod(String pattern)
	{
		return empService.findByNameContainingOrderBySalaryDescMethod(pattern);
	}
	
}
