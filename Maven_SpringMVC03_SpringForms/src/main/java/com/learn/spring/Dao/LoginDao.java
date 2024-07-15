package com.learn.spring.Dao;

import org.springframework.stereotype.Repository;

import com.learn.spring.Beans.LoginBean;

@Repository
public class LoginDao {
	public String validateLogin(LoginBean lb)
	{
		if(lb.getUserName().equals("demo5") && lb.getPassword().equals("demo123"))
		{
			return "success";
		}
		else
		{
			return "failure";
		}
	}
}
