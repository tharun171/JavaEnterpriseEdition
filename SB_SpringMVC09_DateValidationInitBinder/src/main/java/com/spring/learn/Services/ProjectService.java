package com.spring.learn.Services;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.learn.Dao.ProjectDao;

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
