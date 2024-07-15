package com.example.demo.Controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.BusinessBean.RegisterBean;
import com.example.demo.Services.ProjectService;

import jakarta.validation.Valid;

@Controller
public class RegisterController {

	@Autowired
	private ProjectService service;
	
	@GetMapping("/")
	public ModelAndView loadRegister()
	{
		//(pageName,modelAttributeName same as in jsp,instance of bean passed)
		ModelAndView mav = new ModelAndView("Register","RegisterBeanMA",new RegisterBean());
		return mav;
	}
	
	@PostMapping("/Register")
	public ModelAndView Register(@ModelAttribute("RegisterBeanMA") @Valid RegisterBean rb,
			BindingResult res)
	{
		System.out.println(rb.toString());
		ModelAndView mav = new ModelAndView();
		String page;
		if(res.hasErrors())
		{
			mav.addObject("RegisterBeanMA",rb);
			page="Register";
		}
		else
		{
			page ="RegisterSuccess";
			mav.addObject("message","welcome "+rb.getUserName());
			mav.addObject("rb",rb);
		}
		mav.setViewName(page);
		return mav;
	}
	
	//Dynamic loading of components
	
	
		//1 Dynamic dropdown - same value and label
		//modelAttribute name should be same as items="" in jsp page
			@ModelAttribute("countryListSameNameAndValue")
			public List<String> populateCountriesSameNameAndLabel()
			{
				System.out.println("country list initiated....in controller");
				//System.out.println(service.getCountriesSameLabelAndName());
				return service.getCountriesSameLabelAndName();
			}
			//2 Dynamic dropdown - different lables and values
			//diff name and value
			@ModelAttribute("countryList")
			public Map<String,String> populateCountries()
			{
				System.out.println("country have diff name and value");
				return service.getCountries();
			}
			
			
			//maps have key value pair
			@ModelAttribute("languages")
			public Map<String,String> populateCommunity()
			{
				System.out.println("community list initiated...");
				return service.getLanguages();
			}
			
			//3 Dynamic radio buttons
			@ModelAttribute("genders")
			public Map<String,String> populateGenderRadio()
			{
				System.out.println("gender initiated...");
				return service.getGenders();
			}
}
