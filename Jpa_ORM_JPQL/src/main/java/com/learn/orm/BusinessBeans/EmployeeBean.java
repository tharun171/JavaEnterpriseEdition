package com.learn.orm.BusinessBeans;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeeBean {
	
	private Integer employeeId;
	private String employeeName;
	private String role;
	private Date insertTime;
	private Double Salary;

}
