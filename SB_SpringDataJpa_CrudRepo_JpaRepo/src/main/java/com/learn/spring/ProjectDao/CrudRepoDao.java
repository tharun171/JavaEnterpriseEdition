package com.learn.spring.ProjectDao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.learn.spring.Entities.EmployeeEntity;


public interface CrudRepoDao extends CrudRepository<EmployeeEntity,Integer>{

}
