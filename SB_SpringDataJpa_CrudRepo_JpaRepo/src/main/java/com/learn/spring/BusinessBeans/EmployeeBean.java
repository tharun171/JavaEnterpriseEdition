package com.learn.spring.BusinessBeans;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeBean {

	private Integer empId;
	private String empName;
	private String empRole;
	private Float empSalary;
	private Date insertTime;
	
	
}
