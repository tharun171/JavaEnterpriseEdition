package com.learn.orm.Others;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtility {

private static EntityManagerFactory emf;
	
	public static EntityManagerFactory buildEmf()
	{
		try
		{
			emf = Persistence.createEntityManagerFactory("unit2");
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	return emf;
	}


public static EntityManagerFactory getEmf()
{
	if(emf==null)
	{
		emf = buildEmf();
	}
	return emf;
}

public static void closeEmf()
{
	if(emf!=null & emf.isOpen()==true)
	{
		System.out.println("emf is closed");
		emf.close();
	}
}
}
