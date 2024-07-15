package com.example.demo.Dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;


@Repository
public class ProjectDao {

	public Map<String,String> getcountries()
	{
		LinkedHashMap<String,String> map = new LinkedHashMap<String,String>();
		map.put("us","united states");//right side are shown in pages when loaded
		map.put("sg","singapur");
		map.put("db","dubai");
		return map;
	}
	
	public List<String> getCountriesSameValueAndLabel()
	{
		List<String> list = new ArrayList<String>();
		list.addAll(Arrays.asList("usa","russia","uk"));
		//System.out.println(list);
		return list;
	}
	
	public Map<String,String> getLanguages()
	{
		LinkedHashMap<String,String> map = new LinkedHashMap<String,String>();
		//name,label
		map.put("Tel","Telugu");//right side are shown in pages when loaded
		map.put("hin","Hindi");
		map.put("Eng","English");
		return map;
	}
	
	public Map<String,String> getGenders()
	{
		LinkedHashMap<String,String> map = new LinkedHashMap<String,String>();
		map.put("M","male");
		map.put("F","female");
		return map;
	}
}
