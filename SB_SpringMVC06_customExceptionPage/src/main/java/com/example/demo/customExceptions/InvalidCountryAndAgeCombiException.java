package com.example.demo.customExceptions;

public class InvalidCountryAndAgeCombiException 
extends Exception{
	
private static final long serialVersionUID = 1L;

	
	public InvalidCountryAndAgeCombiException()
	{
		super(" invalid country and age combination entered. usa -->age should be greater than 23\r\n"
				+ "	russia --> age greater than 28\r\n"
				+ "	uk --> age greater than 30");
	}

}
