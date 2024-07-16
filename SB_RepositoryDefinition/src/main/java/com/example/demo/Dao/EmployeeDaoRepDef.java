package com.example.demo.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Entities.EmployeeEntity;

@RepositoryDefinition(domainClass = EmployeeEntity.class,
idClass = Integer.class)
@Transactional(value="txManager")
public interface EmployeeDaoRepDef {

	
	//This is a named query written in orm.xml
	@Query(name = "findAllEmployee")
	List<EmployeeEntity> findAll();
	
	//This allows methods we explicitly add to it
	//we can write queries in the @Query itself
	
	@Query("select e from EmployeeEntity e where e.salary>=?1")
	List<EmployeeEntity> findEmployeeWhoseSalaryGreaterThan(Double salary);
	
	@Query("select e from EmployeeEntity e where e.salary>=:sal")
	List<EmployeeEntity> findEmployeeWhoseSalaryGreaterThanNamed(
			@Param("sal") Double salary);
	
	
}
