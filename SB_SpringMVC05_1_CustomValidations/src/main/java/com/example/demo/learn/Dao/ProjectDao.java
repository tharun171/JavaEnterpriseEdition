package com.example.demo.learn.Dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository	
public class ProjectDao {

	//diff value and diff label
		public Map<String,String> getCountries(){
			Map<String,String> countries = new LinkedHashMap<String, String>();
			countries.put("US","united states");
			countries.put("IND","india");
			countries.put("ENG","england");
			countries.put("SA","south africa");
			return countries;
		}
		
		public List<String> getSameValueAndLabelCountries()
		{
			List<String> list = new ArrayList<String>();
			list.addAll(Arrays.asList("USA","IND","EN","SA"));
			return list;
		}
		
		public Map<String,String> getLanguages()
		{
			Map<String,String> map = new LinkedHashMap<String, String>();
			map.put("java","JAVA");
			map.put("Python","PYTHON");
			map.put("c","C");
			map.put("ruby","RUBY");
			return map;
		}
		
		public Map<String,String> getGender()
		{
			Map<String,String> map = new LinkedHashMap<String, String>();
			map.put("M","Male");
			map.put("F","Female");
			return map;
		}
		
}
