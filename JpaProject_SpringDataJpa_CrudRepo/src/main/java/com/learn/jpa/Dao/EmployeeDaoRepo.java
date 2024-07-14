package com.learn.jpa.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.learn.jpa.Entities.EmployeeEntity;


@Repository
public interface EmployeeDaoRepo extends CrudRepository<EmployeeEntity,Integer>{

}
