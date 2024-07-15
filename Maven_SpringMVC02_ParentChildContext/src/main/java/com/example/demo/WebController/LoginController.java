package com.example.demo.WebController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.BusinessBeans.LoginBean;
import com.example.demo.Service.LoginService;


//WORKING
@Controller
public class LoginController {
	
	@Autowired
	private LoginService service;
	
	//http://localhost:8080/Maven_SpringMVC02_ParentChildContext/
	@GetMapping({"/","/home"})
	public ModelAndView getHome()
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("Login");
		return mav;
	}
	
	@PostMapping("/validateLogin")
	public ModelAndView validate(
			@RequestParam("uName") String uname,
			@RequestParam("pwd") String password)
	{
		LoginBean lb = new LoginBean(uname,password);
		
		String returnValue = service.validateLogin(lb);
		ModelAndView mav = new ModelAndView();
		if(returnValue.equals("success"))
		{
			mav.setViewName("success");
			mav.addObject("message","welcome "+uname);
		}
		else
		{
			mav.setViewName("failure");
			mav.addObject("message","login authentication failed!");
		}
		return mav;
	}
	
}
