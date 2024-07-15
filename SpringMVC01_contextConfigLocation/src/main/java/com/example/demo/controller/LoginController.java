package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.BusinessBean.LoginBean;
import com.example.demo.Service.LoginService;

@Controller
public class LoginController {
	
	//http://localhost:9091/home
	//http://localhost:9091/

	@Autowired
	private LoginService service;
	
	private ModelAndView mav;
	
	@GetMapping({"/","home"})
	public ModelAndView getLogin()
	{
		System.out.println("Loaded login page");
		mav = new ModelAndView();
		mav.setViewName("Login");
		return mav;
	}
	
	@PostMapping("/validateLogin")
	public ModelAndView validate(
			@RequestParam("uName") String username,
			@RequestParam("pwd") String password)
	{
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
