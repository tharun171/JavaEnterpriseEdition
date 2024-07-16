package com.example.demo.controllers;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.BusinessBeans.EmployeeBean;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
//This variable data carried throughout the session
@SessionAttributes("RegisterBeanMA")
public class HomeController {

	
	private ModelAndView mav;
	
	@GetMapping("/")
	public ModelAndView getRegisterPage()
	{
		System.out.println("getting register page");
		//ModelAndView mav = new ModelAndView();
		//mav.setViewName("RegistrationPage");
		//mav.addObject("RegisterBeanMA",new EmployeeBean());
		
		//OR
		return new ModelAndView("RegistrationPage","RegisterBeanMA",new EmployeeBean());
		
		//return mav;
	}
	
	//submitting to first page
		@PostMapping("/Register")
		public ModelAndView registerDetails(
				@ModelAttribute("RegisterBeanMA") @Valid EmployeeBean registerDetails,
				BindingResult result,
				//@RequestParam("dob") @DateTimeFormat(pattern = "dd-MM-yyyy") Date dob,
				ModelMap map,
				HttpServletRequest request,
				HttpSession sess)
		{
			//registerDetails.setDob(dob);
			mav = new ModelAndView();
			System.out.println("inside first controller");
			if(result.hasErrors())
			{
				//the submitted has results 
				//sending to that page again
				System.out.println("has errors navigating to registration page");
				System.out.println(registerDetails.toString());
				mav.setViewName("RegistrationPage");
			}
			else
			{
				System.out.println("sending to first page");
				System.out.println("=========================");
				request.setAttribute("RegisterBeanMA",registerDetails);
				System.out.println("ModelMap Data: "+map.get("RegisterBeanMA"));
				System.out.println("HttpServletRequest data: "+request.getAttribute("RegisterBeanMA"));
				System.out.println("Session "+sess.getAttribute("RegisterBeanMA"));
				System.out.println("=======================");
				System.out.println("subMA1 : "+registerDetails.toString());
				mav.addObject("RegisterBeanSubMA1",registerDetails);
				System.out.println(registerDetails.toString());
				mav.setViewName("SubmitPage");
			}
			return mav;
		}
		
		@GetMapping("/Confirm")
		public ModelAndView registerDetails(
				@ModelAttribute("RegisterBeanMA") EmployeeBean registerDetails,
				ModelMap map,
				HttpServletRequest request,
				HttpSession sess)
		{
			System.out.println("inside second controller");
			System.out.println("=========================");
			System.out.println("ModelMap Data: "+map.get("RegisterBeanMA"));
			System.out.println("HttpServletRequest data: "+request.getAttribute("RegisterBeanMA"));
			System.out.println("Session "+sess.getAttribute("RegisterBeanMA"));
			System.out.println("=======================");
			System.out.println("sending to second page");
			//setting to this Key -> RegisterBeanSubMA2
			mav.addObject("RegisterBeanSubMA2",registerDetails);
			mav.setViewName("ConfirmPage");
			return mav;
		}
}
