package com.learn.orm.Service;

import java.util.List;

import com.learn.orm.BusinessBeans.EmployeeBean;
import com.learn.orm.Dao.EmployeeDao;
import com.learn.orm.Entities.EmployeeEntity;
import com.learn.orm.Others.Factory;

public class EmpServiceImpl implements EmpService{


private EmployeeDao dao;

	@Override
	public List<Object> stringFucntionsDemo() {
		// TODO Auto-generated method stub
		dao = Factory.createEmployeeDao();
		return dao.stringFucntionsDemo();
	}

	@Override
	public List<Object> dateFunctionsDemo() {
		// TODO Auto-generated method stub
		dao = Factory.createEmployeeDao();
		return dao.dateFunctionsDemo();
	}

	@Override
	public List<Object> MathFunctions() {
		// TODO Auto-generated method stub
		dao = Factory.createEmployeeDao();
		return dao.MathFunctions();
	}

	
	@Override
	public int insertEmployee(EmployeeBean bean) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("inside service class");
		dao = Factory.createEmployeeDao();
		return dao.insertEmployee(bean);
	}

	@Override
	public EmployeeBean updateSalaryOfEmployeeWithNameAs(String name, double salary) {
		// TODO Auto-generated method stub
		dao = Factory.createEmployeeDao();
		return dao.updateSalaryOfEmployeeWithNameAs(name, salary);
	}

	@Override
	public EmployeeBean getEmployeeById(int id) {
		// TODO Auto-generated method stub
		dao = Factory.createEmployeeDao();
		return dao.getEmployeeById(id);
	}

	@Override
	public List<EmployeeBean> salaryInRange(double salary1, double salary2) {
		// TODO Auto-generated method stub
		dao = Factory.createEmployeeDao();
		return dao.salaryInRange(salary1, salary2);
	}

	@Override
	public List<EmployeeBean> NameLikeSubstringSalaryDesc(String subString) {
		// TODO Auto-generated method stub
		dao = Factory.createEmployeeDao();
		return dao.NameLikeSubstringSalaryDesc(subString);
	}

	@Override
	public List<EmployeeEntity> findEmpByNameAndRolePositionalParam(String name, String role) {
		// TODO Auto-generated method stub
		dao = Factory.createEmployeeDao();
		return dao.findEmpByNameAndRolePositionalParam(name, role);
	}

	@Override
	public List<EmployeeEntity> findEmpByNameNamedParam(String name) {
		// TODO Auto-generated method stub
		dao = Factory.createEmployeeDao();
		return dao.findEmpByNameNamedParam(name);
	}

	@Override
	public List<EmployeeEntity> findAllEmpFromXML() {
		// TODO Auto-generated method stub
		dao = Factory.createEmployeeDao();
		return dao.findAllEmpFromXML();
	}

	@Override
	public List<EmployeeBean> getEmployeeDetailsUsingHibernateProvider() {
		// TODO Auto-generated method stub
		dao = Factory.createEmployeeDao();
		return dao.getEmployeeDetailsUsingHibernateProvider();
	}

}
