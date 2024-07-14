package com.learn.orm.UiTester;

import java.util.Date;
import java.util.List;

import com.learn.orm.Others.Factory;
import com.learn.orm.Service.EmpService;

public class JpqlFunctions {

	private static EmpService empService;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//stringFunctions();
		
		//DateFunctions();
		
		MathFunctions();
	}
	public static List<Object> MathFunctions()
	{
		empService = Factory.createEmpService();
		List<Object> list = empService.MathFunctions();
		for(Object var:list)
		{
			Object[] obj = (Object[])var;
			System.out.println("average of all salaries "+obj[0]);
			System.out.println("sum of all salaries "+obj[1]);
			System.out.println("count of all salaries "+obj[2]);
			System.out.println("max of all salaries "+obj[3]);
			System.out.println("min of all salaries "+obj[4]);
		}
		return list;
	}
	
	public static List<Object> stringFunctions()
	{
		empService = Factory.createEmpService();
		List<Object> returnList = empService.stringFucntionsDemo();
		for(Object obj:returnList)
		{
			Object[] var = (Object[])obj;
			//order is obtained from query in daoImpl
			System.out.println("normal "+(String)var[0]);
			System.out.println("upper "+(String)var[1]);
			System.out.println("lower "+(String)var[2]);
			System.out.println("substring "+(String)var[3]);
			System.out.println("length "+(Integer)var[4]);
			System.out.println("------------------");
		}
		return returnList;
	}
	
	public static List<Object> DateFunctions()
	{
		empService = Factory.createEmpService();
		List<Object> returnList = empService.dateFunctionsDemo();
		for(Object obj:returnList)
		{
			Object[] var = (Object[])obj;
			//order is obtained from query in daoImpl
			System.out.println("normal time "+(Date)var[0]);
			System.out.println("year "+var[1]);
			System.out.println("month "+var[2]);
			System.out.println("day "+var[3]);
			System.out.println("------------------");
		}
		return returnList;
	}

}
