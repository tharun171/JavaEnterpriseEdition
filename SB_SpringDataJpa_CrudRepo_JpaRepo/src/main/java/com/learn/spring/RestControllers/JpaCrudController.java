package com.learn.spring.RestControllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learn.spring.Entities.EmployeeEntity;
import com.learn.spring.Services.PagingSortingService;

import jakarta.validation.Valid;

//@ResponseBody+@Controller
@RestController
public class JpaCrudController {

	//http://localhost:9090/jpaEmp
	
		@Autowired
		private PagingSortingService empService;
		
		private final Logger log = LoggerFactory.getLogger(JpaCrudController.class);
		
		//SAVE method
		//@RequestMapping(value="/dept",method=RequestMethod.POST)
		@PostMapping("/jpaEmp")
		public EmployeeEntity saveEmployee(@Valid @RequestBody EmployeeEntity entity) throws Exception
		{
			log.info("Saving Entity : "+entity);
			EmployeeEntity savedEmpEntity = empService.saveEmployee(entity);
			log.info("Saved Entity : "+savedEmpEntity);
			return savedEmpEntity;
		}
			
		//GET method
		@GetMapping("/jpaEmp")
		public List<EmployeeEntity> getAll()
		{
			log.info("get all employees ->");
			List<EmployeeEntity> list = empService.getAll();
			for(EmployeeEntity entity:list)
			{
				System.out.println(entity);
			}
			return list;
		}
		
		//GET by id
		@GetMapping("/jpaEmp/{id}")
		public EmployeeEntity getById(@PathVariable("id") Integer id)
		{
			log.info("get all employees ->");
			EmployeeEntity entity = empService.getById(id);
			System.out.println(entity);
			return entity;
		}
		
		//Update
		@PutMapping("/jpaEmp/{id}")
		public EmployeeEntity updateEmp(@RequestBody EmployeeEntity emp)
		{
			EmployeeEntity updatedEntity= empService.updateEmp(emp);
			System.out.println(updatedEntity);
			return updatedEntity;
		}
		
		
		//Delete
		@DeleteMapping("/jpaEmp/{id}")
		public String delete(@PathVariable("id") Integer id)
		{
			String res = empService.deleteById(id);
			System.out.println(res);
			return res;
		}
		
		//page number starts with zero default
		//can be configured
		
		//http://localhost:9090/jpaEmp/pages/pageNumber:0/noOfEntriesPerPage:2/SortBy:empId
		@GetMapping("/jpaEmp/pages/pageNumber:{pageNumber}/noOfEntriesPerPage:{noepp}/SortBy:{field}")
		public Page<EmployeeEntity> getPages(
				@PathVariable("pageNumber") int pageNum,
				@PathVariable("noepp") int entriesPerPage,
				@PathVariable("field") String field)
		{
			return empService.getPageOfResults(pageNum,entriesPerPage,field);
		}
		
		
}
