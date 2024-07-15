package com.example.demo.learn.Controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.learn.Beans.RegisterBean;
import com.example.demo.learn.Services.ProjectService;

import jakarta.validation.Valid;


//WORKING
@Controller
public class WebController {

	@Autowired
	private ProjectService service;
	
	//see DetailsBeant to see validations
	//see Registration.jsp to see error configuration
	
	@GetMapping(value="/")
	public ModelAndView LoadRegistration()
	{
		System.out.println("inside controller");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("Registration");
		mav.addObject("DetailsMA",new RegisterBean());
		return mav;
	}
	
	@PostMapping("/register")
	//@Valid is used for validating bean
	//BindingResult is used to get results
	public ModelAndView registerMethod(@ModelAttribute("DetailsMA") @Valid RegisterBean details,
			BindingResult result)
	{
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors())
		{
			System.out.println("have erros while filling form");
			mav.setViewName("Registration");
		}
		else
		{
			mav.setViewName("RegistrationSuccess");
			System.out.println(details);
			mav.addObject("DetailsBean",details);
		}
		return mav;
	}
	
	
	//dropdown
	@ModelAttribute("dropDownOptions")
	public Map<String,String> getCountries(){
		return service.getCountries();
	}
	
	//dropdown 
	public List<String> getSameValueAndLabelCountries()
	{
		return service.getSameValueAndLabelCountries();
	}
	
	//checkboxes
	@ModelAttribute("preferredLanguages")
	public Map<String,String> getLanguages(){
		return service.getLanguages();
	}
	
	//radio buttons
	@ModelAttribute("gender")
	public Map<String,String> getGender()
	{
		return service.getGender();
	}

}
