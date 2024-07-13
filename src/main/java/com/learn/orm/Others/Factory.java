package com.learn.orm.Others;

import com.learn.orm.Dao.EmployeeDao;
import com.learn.orm.Dao.EmployeeDaoImpl;
import com.learn.orm.Service.EmpService;
import com.learn.orm.Service.EmpServiceImpl;

public class Factory {

	public static EmpService createEmpService()
	{
		return new EmpServiceImpl();
	}
	
	public static EmployeeDao createEmployeeDao()
	{
		return new EmployeeDaoImpl();
	}
	
}
