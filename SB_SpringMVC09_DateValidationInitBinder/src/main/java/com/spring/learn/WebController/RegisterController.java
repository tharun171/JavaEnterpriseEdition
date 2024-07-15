package com.spring.learn.WebController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.learn.Beans.RegisterBean;
import com.spring.learn.Services.ProjectService;

import jakarta.validation.Valid;



//WORKING
@Controller
public class RegisterController {
	
	
	@Autowired
	private ProjectService service;
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		//Date is util.class
		binder.registerCustomEditor(Date.class,"userDate",new CustomDateEditor(sdf,true));
	}

	@GetMapping(value={"/","/reg"})
	public ModelAndView loadRegister()
	{
		//(pageName,modelAttributeName same as in jsp,instance of bean passed)
		ModelAndView mav = new ModelAndView("Register","RegisterBeanMA",new RegisterBean());
		return mav;
	}
	
	
	@PostMapping(value="/Register")
	public ModelAndView Register(@ModelAttribute("RegisterBeanMA") @Valid RegisterBean rb,
			BindingResult res)
	{
		System.out.println(rb.toString());
		ModelAndView mav = new ModelAndView();
		String page;
		if(res.hasErrors())
		{
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
