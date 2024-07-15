package com.learn.spring.Entities;

import java.math.BigDecimal;

public class PartTimeEmployee extends Employee{

	
	private BigDecimal hourlyWage;

	public BigDecimal getHourlyWage() {
		return hourlyWage;
	}

	public void setHourlyWage(BigDecimal hourlyWage) {
		this.hourlyWage = hourlyWage;
	}

	public PartTimeEmployee(String empName, BigDecimal hourlyWage) {
		super(empName);
		this.hourlyWage = hourlyWage;
	}

	@Override
	public String toString() {
		return "PartTimeEmployee [hourlyWage=" + hourlyWage + "]";
	}
	
	
	
}
