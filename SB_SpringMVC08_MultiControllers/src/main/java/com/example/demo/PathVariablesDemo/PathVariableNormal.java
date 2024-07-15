package com.example.demo.PathVariablesDemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users3")
public class PathVariableNormal {

	
	//http://localhost:9090/users3/101/1355/tharun
	
		@GetMapping(value="/{id}/{key}/{name}")
		public ModelAndView showPage(
				@PathVariable("id") int empId,
				@PathVariable("key") int empKey,
				@PathVariable("name") String empName)
		{
			return new ModelAndView("PathVariable","message",
					"empId = "+empId+" name= "+empName+" key: "+empKey);
		}
}
