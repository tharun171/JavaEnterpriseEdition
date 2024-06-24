package com.learn.jpa.UiTester;

import java.util.List;

import com.learn.jpa.Others.Factory;
import com.learn.jpa.Service.FunctionService;

//WORKING
public class Functions {

	public static void main(String[] args) {
		try
		{
			
			//String functions = upper,lower,substring,length
			//stringFunctionDemo();
			//Date Function = actual date,year,month,day
			dateFunctionDemo();
			//Math Function = first sal,avg,max,min,count,sum
			//mathFunctionDemo();
		}
		catch(Exception ex)
		{
			ex.getMessage();
		}
	}
	public static void stringFunctionDemo() {
		List<Object> list = null;
		FunctionService service = Factory.createFunctionService();
		try {
			list = service.StringFunctionsDemo();
			for (Object e : list) {
				Object[] obj = (Object[]) e;
				System.out.println("normal Name " + obj[0]);
				System.out.println("capitals " + obj[1]);
				System.out.println("small " + obj[2]);
				System.out.println("substring 1,3 " + obj[3]);
				System.out.println("length " + obj[4]);
				System.out.println("----------------------");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void dateFunctionDemo() {
		List<Object> list = null;
		FunctionService service = Factory.createFunctionService();
		try {
			list = service.DateFunctionsDemo();
			for (Object e : list) {
				Object[] obj = (Object[]) e;
				System.out.println("joining Date " + obj[0]);
				System.out.println("year " + obj[1]);
				System.out.println("month " + obj[2]);
				System.out.println("day " + obj[3]);
				System.out.println("----------------------");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}public static void mathFunctionDemo() {
		List<Object> list = null;
		FunctionService service = Factory.createFunctionService();
		try {
			list = service.MathFunctionsDemo();
			for (Object e : list) {
				Object[] obj = (Object[]) e;
				System.out.println("first member salary in DB" + obj[0]);
				System.out.println("avg " + obj[1]);
				System.out.println("max " + obj[2]);
				System.out.println("min " + obj[3]);
				System.out.println("count "+obj[4]);
				System.out.println("sum " + obj[5]);
				System.out.println("----------------------");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
