package com.learn.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.BusinessBeans.LoginBean;
import com.learn.Dao.LoginDao;

@Service
public class LoginService {

	@Autowired
	private LoginDao dao;
	
	public String validateLogin(LoginBean lb)
	{
		return dao.validateLogin(lb);
	}
}
