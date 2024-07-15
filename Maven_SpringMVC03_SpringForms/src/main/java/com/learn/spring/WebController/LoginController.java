package com.learn.spring.WebController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.learn.spring.Beans.LoginBean;
import com.learn.spring.Services.LoginService;

//WORKING
@Controller
public class LoginController {

	@Autowired
	private LoginService ls;
	
	//http://localhost:8080/Maven_SpringMVC03_SpringForms/login
	// both /(root) and /login goes to login page

	//GET because the page will be same irrespective no of times retrieved
	//post we use when changing or saving
	@GetMapping(value="/")
	public ModelAndView loadLoginPage()
	{
		ModelAndView mav = new ModelAndView("login","loginBeanMA",new LoginBean());
		return mav;
	}
	@GetMapping(value="/login")
	public ModelAndView loadLoginPage2()
	{
		ModelAndView mav = new ModelAndView("login","loginBeanMA",new LoginBean());
		return mav;
	}
	
	
	@PostMapping(value="/validate")
	public ModelAndView validateLogin(@ModelAttribute("loginBeanMA") LoginBean lb)
	{
		System.out.println(lb.toString());
		String result = ls.validateLogin(lb);
		System.out.println(result);
		ModelAndView mav = new ModelAndView();
		if(result.equals("success"))
		{
			mav.setViewName("loginSuccess");
			mav.addObject("lb",lb);
		}
		else
		{
			mav.setViewName("loginFailure");
			mav.addObject("message","login failed!");
			mav.addObject("lb",lb);
		}
		return mav;
	}
	
}
