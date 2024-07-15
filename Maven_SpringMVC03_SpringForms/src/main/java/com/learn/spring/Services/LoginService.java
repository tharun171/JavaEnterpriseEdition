package com.learn.spring.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.spring.Beans.LoginBean;
import com.learn.spring.Dao.LoginDao;

@Service
public class LoginService {

	@Autowired
	private LoginDao dao;
	
	public String validateLogin(LoginBean lb)
	{
		return dao.validateLogin(lb);
	}
}
