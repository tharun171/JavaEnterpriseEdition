package com.learn.spring.Dao;

import java.util.List;

import com.learn.spring.Entities.EmployeeEntity;

public interface EmployeeDao{

	List<EmployeeEntity> findAllMethod();
}
