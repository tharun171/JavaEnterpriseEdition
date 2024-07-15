package com.example.demo.WebControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {

	
	//this will be the root opened when server is invoked
	@GetMapping()
	public ModelAndView welcome()
	{
		System.out.println("inside home controller");
		ModelAndView mav =  new ModelAndView();
		mav.setViewName("welcomePage1");
		return mav;
	}
}
