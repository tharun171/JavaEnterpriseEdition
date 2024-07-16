package com.learn.spring.BusinessBean;

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

	private int empId;
	private String name;
	private String role;
	private Date insertTime;
	private Double salary;
}
