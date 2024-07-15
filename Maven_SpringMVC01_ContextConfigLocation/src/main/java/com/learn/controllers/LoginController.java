package com.learn.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.learn.BusinessBeans.LoginBean;
import com.learn.Service.LoginService;


//WORKING
@Controller
public class LoginController {

	//http://localhost:8080/Maven_SpringMVC01_configContextLocation/Login
	//
	
	private ModelAndView mav;
	
	@Autowired
	private LoginService service;
	
	@GetMapping({"/","/home","/Login"})
	public ModelAndView getLogin()
	{
		System.out.println("inside controller");
		mav = new ModelAndView();
		mav.setViewName("Login");
		return mav;
	}
	
	
	@PostMapping("/validateLogin")
	public ModelAndView validate(
			@RequestParam("uName") String username,
			@RequestParam("pwd") String password)
	{
		System.out.println("inside validate Login");
		LoginBean lb = new LoginBean(username,password);
		String returnValue = service.validateLogin(lb);
		ModelAndView mav = new ModelAndView();
		if(returnValue.equals("success"))
		{
			mav.setViewName("success");
			mav.addObject("message","welcome "+username);
		}
		else
		{
			mav.setViewName("failure");
			mav.addObject("message","login authentication failed!");
		}
		return mav;			
	}
	
}
