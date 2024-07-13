package com.learn.jpa.Others;

import com.learn.jpa.Dao.CrudDao;
import com.learn.jpa.Dao.CrudDaoImpl;
import com.learn.jpa.Dao.JpaFunctionsDao;
import com.learn.jpa.Dao.JpaFunctionsDaoImpl;
import com.learn.jpa.Service.CrudService;
import com.learn.jpa.Service.CrudServiceImpl;
import com.learn.jpa.Service.FunctionService;
import com.learn.jpa.Service.FunctionServiceImpl;

public class Factory {

	public static FunctionService createFunctionService()
	{
		return new FunctionServiceImpl();
	}
	
	public static JpaFunctionsDao createFunctionDao()
	{
		return new JpaFunctionsDaoImpl();
	}
	
	public static CrudService createCrudService()
	{
		return new CrudServiceImpl();
	}
	public static CrudDao createCrudDao()
	{
		return new CrudDaoImpl();
	}
}
