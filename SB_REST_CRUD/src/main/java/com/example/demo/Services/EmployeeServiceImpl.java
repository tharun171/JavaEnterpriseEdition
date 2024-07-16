package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.BusinessBeans.EmployeeBean;
import com.example.demo.Dao.EmployeeDaoImpl;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDaoImpl daoImpl;
	
	public Integer addEmployee(EmployeeBean bean) throws Exception {
		return daoImpl.saveEmployee(bean);
	}

	public List<EmployeeBean> getAllEmployee() throws Exception {
		return daoImpl.getAllEmployee();
	}

	public EmployeeBean getEmployeeById(Integer id){
		return daoImpl.getEmployeeById(id);
	}
	
	public EmployeeBean updateEmployee(EmployeeBean bean) {
		return daoImpl.updateEmployee(bean);
	}

	public String deleteEmployeeById(Integer id) {
		return daoImpl.deleteEmployeeById(id);
	}

	public List<EmployeeBean> getEmpDetailsRange(Double min, Double max) {
		 return daoImpl.getEmpDetailsRange(min,max);
	}

}
