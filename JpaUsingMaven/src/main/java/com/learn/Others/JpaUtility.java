package com.learn.Others;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtility {

private static EntityManagerFactory emf;
	
	public static EntityManagerFactory buildEmf()
	{
		try
		{
			emf = Persistence.createEntityManagerFactory("unit1");
			//create META-INF folder in src/main/resources
			//inside create a xml file and name it as persistence.xml
			System.out.println("connection created..");
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return emf;
	}
	
	public static EntityManagerFactory getEmf()
	{
		if(emf==null)
		{
			emf = buildEmf();
		}
		System.out.println(emf.isOpen());
		return emf;
	}
	
	public static void closeEmf()
	{
		
		emf.close();
	}
}
