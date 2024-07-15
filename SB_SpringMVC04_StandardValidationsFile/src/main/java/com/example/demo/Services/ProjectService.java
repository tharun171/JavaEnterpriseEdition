package com.example.demo.Services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.ProjectDao;

@Service
public class ProjectService {

	@Autowired
	private ProjectDao dao;
	
	public Map<String,String> getCountries()
	{
		return dao.getcountries();
	}

	public Map<String,String> getGenders()
	{
		return dao.getGenders();
	}
	
	public List<String> getCountriesSameLabelAndName()
	{
		return dao.getCountriesSameValueAndLabel();
	}
	
	public Map<String,String> getLanguages()
	{
		return dao.getLanguages();
	}
}
