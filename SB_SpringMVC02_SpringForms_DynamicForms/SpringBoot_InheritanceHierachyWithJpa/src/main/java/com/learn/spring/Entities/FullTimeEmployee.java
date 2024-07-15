package com.learn.spring.Entities;

import java.math.BigDecimal;

public class FullTimeEmployee extends Employee{

	private BigDecimal salary;

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public FullTimeEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FullTimeEmployee(String empName,BigDecimal salary) {
		super(empName);
		this.salary=salary;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "FullTimeEmployee [salary=" + salary + "]";
	}
	
	
}
