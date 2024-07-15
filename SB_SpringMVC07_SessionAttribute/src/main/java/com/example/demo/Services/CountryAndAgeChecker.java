package com.example.demo.Services;

import org.springframework.stereotype.Service;

import com.example.demo.BusinessBeans.RegisterBean;
import com.example.demo.Exceptions.InvalidCountryNameAndAgeCombinationException;

@Service
public class CountryAndAgeChecker {

	//usa -->age should be greater than 23
	//russia --> age greater than 28
	//uk --> age greater than 30
	//"usa","russia","uk")
	//have same name and value, this is dynamic we get from dao
	
	public void validateCountryAndAge(RegisterBean paramBean) throws Exception
	{
		String country = paramBean.getUserCountry();
		int age  = paramBean.getUserAge();
		int c = 0;
		if(country.equals("usa") && age<23)
		{
			c=1;
		}
		else if(country.equals("russia") && age<28)
		{
			c=1;
		}
		else if(country.equals("uk") && age<30)
		{
			c=1;
		}
		
		if(c==1)
		{
			throw new InvalidCountryNameAndAgeCombinationException();
		}
	}
	
}
