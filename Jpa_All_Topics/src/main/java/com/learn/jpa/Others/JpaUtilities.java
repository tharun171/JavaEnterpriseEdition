package com.learn.jpa.Others;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtilities {

	private static EntityManagerFactory emf;
	
	private static EntityManagerFactory buildEmf()
	{
		try
		{
			emf = Persistence.createEntityManagerFactory("Jpa_All_Topics");
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
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
	public static void closedEmf()
	{
		if(emf!=null && emf.isOpen()==true)
		{
			emf.close();
		}
	}
}
