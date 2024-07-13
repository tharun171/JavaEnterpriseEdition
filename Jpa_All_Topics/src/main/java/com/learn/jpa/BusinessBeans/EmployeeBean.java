package com.learn.jpa.BusinessBeans;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeBean {

	private int empId;
	private String empName;
	private double salary;
	private String role;
	private Date joiningdate;
}
