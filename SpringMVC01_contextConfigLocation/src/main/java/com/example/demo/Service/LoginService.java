package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.BusinessBean.LoginBean;
import com.example.demo.Dao.LoginDao;

@Service
public class LoginService {

	@Autowired
	private LoginDao dao;
	
	public String validateLogin(LoginBean lb)
	{
		return dao.validateLogin(lb);
	}
}
