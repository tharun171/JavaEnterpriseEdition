package com.example.demo.PathVariablesDemo;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users2")
//all the requests in this controller use
//	--> /users2/api1
public class PathVariableMap {
	
	//http://localhost:9090/users2/101/1355/india?name=tharun
	
	@GetMapping("/{id}/{key}/{country}")
	public ModelAndView showPage(
			//when we have more @pathVariable we can use Map
			@PathVariable Map<String,String> paths,
			//name we are getting from url directly
			@RequestParam("name") String empName
			)
	{
		int empId = Integer.parseInt(paths.get("id"));
		int empKey = Integer.parseInt(paths.get("key"));
		String empCountry = paths.get("country");
		return new ModelAndView("PathVariable","message",
				"empId = "+empId+"\n"+" name= "+empName+"\n key: "+empKey+"\n country "+empCountry);
	}

}
