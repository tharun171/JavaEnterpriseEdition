package com.learn.jpa.Service;

import java.util.List;

import com.learn.jpa.BusinessBeans.EmployeeBean;
import com.learn.jpa.Dao.CrudDao;
import com.learn.jpa.Others.Factory;

public class CrudServiceImpl implements CrudService{
	
	CrudDao dao = Factory.createCrudDao();

	@Override
	public void createEmployee(EmployeeBean bean) throws Exception {
		try
		{
			dao.createEmployee(bean);
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}

	@Override
	public EmployeeBean getEmployee(Integer empId) throws Exception {
		EmployeeBean bean = null;
		try
		{
			bean = dao.getEmployee(empId);
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return  bean;
	}

	@Override
	public EmployeeBean updateEmployee(EmployeeBean bean) throws Exception {
		EmployeeBean returnBean = null;
		try
		{
			returnBean = dao.updateEmployee(bean);
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return returnBean;
	}

	@Override
	public EmployeeBean deleteEmployee(Integer empId) throws Exception {
		EmployeeBean bean = null;
		try
		{
			bean = dao.deleteEmployee(empId);
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return  bean;
	}

	@Override
	public List<EmployeeBean> getAllEmployee() throws Exception {
		List<EmployeeBean> list = null;
		try
		{
			list = dao.getAllEmployee();
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return list;
	}

}
