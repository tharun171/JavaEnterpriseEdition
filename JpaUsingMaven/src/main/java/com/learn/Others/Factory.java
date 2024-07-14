package com.learn.Others;

import com.learn.Dao.DaoImpl;
import com.learn.Dao.EmpDao;
import com.learn.Service.EmpService;
import com.learn.Service.EmpServiceImpl;

public class Factory {


	public static EmpService createEmpService()
	{
		return new EmpServiceImpl();
	}
	public static EmpDao createEmpDao()
	{
		return new DaoImpl();
	}
}
