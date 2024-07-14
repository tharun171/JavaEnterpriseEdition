package com.learn.jpa.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.jpa.BusinessBeans.EmployeeBean;
import com.learn.jpa.Dao.EmployeeDao;
import com.learn.jpa.Entities.EmployeeEntity;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
    private EmployeeDao dao;

    @Override
    public void saveEmployee(EmployeeBean bean) {
        System.out.println("inside saveEmployee");
        dao.saveEmployee(bean);
    }

	@Override
	public List<EmployeeEntity> findAll() {
		return dao.findAll();
	}

}
