package com.example.demo.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.BusinessBeans.EmployeeBean;
import com.example.demo.Entities.EmployeeEntity;
import com.example.demo.Services.EmployeeServiceImpl;

@RestController
@RequestMapping("/emp/controller")
public class HomeController {
	
	@Autowired
	private EmployeeServiceImpl empServiceImpl;
	
	//http://localhost:9090/emp/controller/getAll
	@GetMapping(value="/getAll",
			produces = {"application/JSON","application/XML","text/HTML"})
	public ResponseEntity<List<EmployeeBean>> getAllEmployee() throws Exception
	{
		List<EmployeeBean> listEmployee = new ArrayList<EmployeeBean>();
		listEmployee = empServiceImpl.getAllEmployee();
		for(EmployeeBean var:listEmployee)
		{
			System.out.println(var.toString());
		}
		return new ResponseEntity<List<EmployeeBean>>(listEmployee,HttpStatusCode.valueOf(200));
	}
	
	//http://localhost:9090/emp/controller/add
	/* {
	        "empId": null,
	        "name": "tarun",
	        "role": "Manager",
	        "insertTime": "2024-05-13",
	        "salary": 150000.0
	    }*/
	/* use content-type in postman to add data*/
	@PostMapping(value="/add",
			consumes = {"application/json","application/xml"},
			produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<String> addEmployee(@RequestBody EmployeeBean bean) throws Exception
 	{
		System.out.println("inside addEmployee method");
 		int savedId = empServiceImpl.addEmployee(bean);
 		return new ResponseEntity<String>("Employee added successfully with id: "+savedId,HttpStatus.CREATED);
 	}
	
	
	//http://localhost:9090/emp/controller/get/1
	//get employee by id
	@GetMapping(value="/get/{id}",
			produces = {"application/json","application/xml"})
	public EmployeeEntity getEmployeeById(@PathVariable("id") Integer id)
	{
		System.out.println("getting employee by id "+id);
		EmployeeBean bean = empServiceImpl.getEmployeeById(id);
		EmployeeEntity entity = new EmployeeEntity();
		BeanUtils.copyProperties(bean, entity);
		return entity;
	}
	
	//UPDATE
	//http://localhost:9090/emp/controller/updateEmp
	@PatchMapping(value="/updateEmp",
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeBean> updateEmployee(
			@RequestBody EmployeeBean bean)
	{
		EmployeeBean resBean = empServiceImpl.getEmployeeById(bean.getEmpId());
		if(resBean.getEmpId()==0 || resBean.getEmpId()==null)
		{
			EmployeeBean nullBean = new EmployeeBean();
			return new ResponseEntity<EmployeeBean>(nullBean,HttpStatus.NOT_FOUND);
		}
		else
		{
			EmployeeBean updatedBean = empServiceImpl.updateEmployee(bean);
			return new ResponseEntity<EmployeeBean>(updatedBean,HttpStatus.OK);
		}
	}
	
	@DeleteMapping(value="/delete/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteById(@PathVariable("id") Integer id)
	{
		String result = empServiceImpl.deleteEmployeeById(id);
		System.out.println("result "+result);
		if(result.equals("deleted"))
		{
			return new ResponseEntity<String>(result,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>(result,HttpStatus.NO_CONTENT);
		}
	}
	

	//Salary Range
	//http://localhost:9090/emp/controller/getEmpSalary/50001.0-200000
	@GetMapping("/getEmpSalary/{minSalary}-{maxSalary}")
	public ResponseEntity<List<EmployeeBean>> getEmpSalaryRange(
			@PathVariable("minSalary") Double minSalary,
			@PathVariable("maxSalary") Double maxSalary)
	{
		List<EmployeeBean> list = empServiceImpl.getEmpDetailsRange(minSalary, maxSalary);
		if(list!=null)
		{
			return new ResponseEntity<List<EmployeeBean>>(list,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<EmployeeBean>>(HttpStatus.NO_CONTENT);
		}
	}
	
	
	//This method allows user to get their requested response
	//http://localhost:9090/emp/controller/get/xml = xml response
	//http://localhost:9090/emp/controller/get/json = json response
	@GetMapping(value="/get/format/{format}",
			produces ={"application/json","application/xml"})
	public ResponseEntity<List<EmployeeBean>> getAllEmpFormat(
			@PathVariable("format") String format) throws Exception
	{
		List<EmployeeBean> listEmployee = new ArrayList<EmployeeBean>(empServiceImpl.getAllEmployee());
		//by default we want user to get xml if user sends nothing or spaces after get/format/slash we give this
		if(format.length()<3)
		{
			System.out.println(format.isBlank());
			return ResponseEntity.ok().contentType(MediaType.APPLICATION_XML).body(listEmployee);
		}
		format = format.strip();
		System.out.println("format : "+format);
		if ("json".equalsIgnoreCase(format)) 
		{
	        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(listEmployee);
	    } 
	    else if ("xml".equalsIgnoreCase(format)) 
	    {
	         return ResponseEntity.ok().contentType(MediaType.APPLICATION_XML).body(listEmployee);
	    } 
	    else 
	    {
	    	//if length > 3, says bad request
	            return ResponseEntity.badRequest().build();
	    }
	}
}
