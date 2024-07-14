package com.example.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entities.EmployeeEntity;

@Repository
public interface EmployeeDaoRepo extends JpaRepository<EmployeeEntity,Integer>{

}
