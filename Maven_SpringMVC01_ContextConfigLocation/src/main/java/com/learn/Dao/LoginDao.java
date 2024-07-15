package com.learn.Dao;

import org.springframework.stereotype.Repository;

import com.learn.BusinessBeans.LoginBean;

@Repository
public class LoginDao {

	public String validateLogin(LoginBean lb)
	{
		String userName = lb.getUsername();
		String password = lb.getPassword();
		if(userName.equals("admin")&&password.equals("admin1234"))
		{
			return"success";
		}
		else
		{
			return "failure";
		}
	}
}
