package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.BusinessBeans.EmployeeBean;
import com.example.demo.Dao.EmployeeDaoImpl;
import com.example.demo.Entities.EmployeeEntity;


@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDaoImpl daoImpl;
	
	@Override
	public void saveEmployee(EmployeeBean bean) throws Exception {
		daoImpl.saveEmployee(bean);
	}

	@Override
	public void saveAllMethod(List<EmployeeBean> listBean) {
		daoImpl.saveAllMethod(listBean);
	}

	public EmployeeBean findByIdMethod(Integer empId) {
		EmployeeBean bean =  daoImpl.findByIdMethod(empId);
		return bean;
	}

	@Override
	public Boolean existsByIdMethod(Integer empId) {
		return daoImpl.existsByIdMethod(empId);
	}

	@Override
	public List<EmployeeEntity> findAllMethod() {
		return daoImpl.findAllMethod();
	}

	@Override
	public List<EmployeeEntity> findAllById(List<Integer> ids) {
		return daoImpl.findAllById(ids);
	}

	@Override
	public Integer countMethod() {
		return daoImpl.countMethod();
	}

}
