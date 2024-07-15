package com.example.demo.PathVariablesDemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/domains")
public class PathVariable_dotCom {

	//http://localhost:9090/domains/domain/www.google.com
	
		@GetMapping(value="/domain/{domainName:.+}")
		public ModelAndView takeUrl(
				@PathVariable("domainName") String name)
		{
			return new ModelAndView("PathVariable","message"
					,"domain entered :"+name);
		}
	
}
