package com.example.demo.Dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.Entities.EmployeeEntity;

public interface EmployeeDao extends CrudRepository<EmployeeEntity,Integer> {

}
