package com.example.demo.Dao;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Entities.EmployeeEntity;

//Custom Repository Creation
@RepositoryDefinition(
		domainClass = EmployeeEntity.class,
		idClass = Integer.class)
@Transactional(value="txManager")
public interface EmployeeDao {
	
	
	//This is a namedQuery written in orm.xml
	//from orm.xml
	@Query(name="findAllEmployee")
	List<EmployeeEntity> findAllHQL();
	
	
	//This allows the methods to work
	//which we explicitly add to the repo
	//@modifying - without these the DML(data manipulation) queries wont work
	//without these changes wont be reflect in table
	//from orm.xml
	@Modifying
	@Query(name="updateSalaryPositional")
	Integer updateSalaryWithNamePositional(Double salary,String name);
	
	//from orm.xml
	@Modifying
	@Query(name="updateSalaryNamed")
	Integer updateSalaryWithNameNamedParam(
			@Param("empSalary") Double salary,
			@Param("empName") String name);
	
	//using named query here - in orm.xml
	@Query(name="findByIdOrmXml")
	EmployeeEntity findByIdNamed(@Param("id") Integer empid);
	
	//	------------------------------------------------------------------------
	
	
	//Custom methods which are provided by Repo 
	//Provided by Repo with small modifications
	
	EmployeeEntity save(EmployeeEntity entity);
	EmployeeEntity findByempId(Integer id);
	EmployeeEntity findByName(String name);
	List<EmployeeEntity> findAll();
	
	//Salary >=
	List<EmployeeEntity> findBySalaryGreaterThanEqual(Double salary);
	
	//Find Employees Whose Salaries>=
	//Sort them in descending order based on their empId
	List<EmployeeEntity> findBySalaryGreaterThanEqualOrderByEmpIdDesc(Double salary);
	
	//Find Employees Whose Salaries>=
	//Sort them in ascending order based on their empId
	List<EmployeeEntity> findBySalaryGreaterThanEqualOrderByEmpId(Double salary);
	
	//Salary range
	List<EmployeeEntity> findBySalaryBetween(Double salary1,Double salary2);
	
	//find Employees having salary >=
	//and filter employees whose role is...
	List<EmployeeEntity> findBySalaryGreaterThanEqualAndRole(Double salary,String role);
	
	//name having the giving pattern
	//order by salary in descending order
	List<EmployeeEntity> findByNameContainingOrderBySalaryDesc(String pattern);
	
	

}
