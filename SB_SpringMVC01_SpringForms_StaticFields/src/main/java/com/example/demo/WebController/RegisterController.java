package com.example.demo.WebController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.BusinessBeans.RegisterBean;

@Controller
public class RegisterController {

	@GetMapping({"/","/reg"})
	public ModelAndView loadRegister()
	{
		ModelAndView mav = new ModelAndView(
				"Register","RegisterBeanMA",new RegisterBean());
		return mav;		
	}
	
	@PostMapping("/Register")
	public ModelAndView Register(
			@ModelAttribute("RegisterBeanMA") RegisterBean rb)
	{
		System.out.println(rb.toString());
		ModelAndView mav = new ModelAndView();
		mav.setViewName("RegisterSuccess");
		mav.addObject("message","welcome "+rb.getUserName());
		mav.addObject("rb",rb);
		return mav;
	}
	
}
