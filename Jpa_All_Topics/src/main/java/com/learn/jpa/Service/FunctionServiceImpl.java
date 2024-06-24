package com.learn.jpa.Service;

import java.util.List;

import com.learn.jpa.Dao.JpaFunctionsDao;
import com.learn.jpa.Others.Factory;

public class FunctionServiceImpl implements FunctionService{

	@Override
	public List<Object> StringFunctionsDemo() throws Exception {
		List<Object> list = null;
		try
		{
			JpaFunctionsDao dao = Factory.createFunctionDao();
			list = dao.StringFunctionsDemo();
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return list;
	}

	@Override
	public List<Object> DateFunctionsDemo() throws Exception {
		List<Object> list = null;
		try
		{
			JpaFunctionsDao dao = Factory.createFunctionDao();
			list = dao.dateFunctionsDemo();
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return list;
	}

	@Override
	public List<Object> MathFunctionsDemo() throws Exception {
		List<Object> list = null;
		try
		{
			JpaFunctionsDao dao = Factory.createFunctionDao();
			list = dao.MathFunctionsDemo();
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return list;
	}

}
