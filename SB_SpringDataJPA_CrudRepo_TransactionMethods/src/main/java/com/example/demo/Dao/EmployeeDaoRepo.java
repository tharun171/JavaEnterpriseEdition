package com.example.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entities.EmployeeEntity;

public interface EmployeeDaoRepo extends JpaRepository<EmployeeEntity,Integer>{
 
}
