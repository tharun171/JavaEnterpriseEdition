package com.example.demo.learn.Services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.learn.Dao.ProjectDao;

@Service
public class ProjectService {

	@Autowired
	private ProjectDao dao;
	
	
	//for dropdown have diff value and label
	public Map<String,String> getCountries(){
		return dao.getCountries();
	}
	
	public List<String> getSameValueAndLabelCountries()
	{
		return dao.getSameValueAndLabelCountries();
	}
	
	public Map<String,String> getLanguages(){
		return dao.getLanguages();
	}
	
	public Map<String,String> getGender()
	{
		return dao.getGender();
	}
}
