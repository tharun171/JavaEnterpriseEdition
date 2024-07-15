package com.example.demo.WebControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user/")
public class UserController {
	
	//localhost:9090/user/all
	//localhost:9090/user/save
	//localhost:9090/user/delete

	    //by default it will be GET
		@RequestMapping(value="/all")
		public ModelAndView allUsers()
		{
			//(page name,key,value)
			//(page name,modelAttribute name,instance of model attribute)
			return new ModelAndView("allUser","key","Value of all");
		}
		
		
		@GetMapping(value="/save")
		public ModelAndView saveUsers()
		{
			
			return new ModelAndView("saveUsers","key","Value of save");
		}
		
		@RequestMapping(value="/delete")
		public ModelAndView deleteUsers()
		{
			return new ModelAndView("deleteUsers","key","Value of delete");
		}
}
