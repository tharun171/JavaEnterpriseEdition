package com.example.demo.BusinessBeans;

import java.util.Date;

import org.springframework.stereotype.Component;

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
@Component
public class EmployeeBean {

	private Integer empId;
	private String name;
	private String role;
	private Date insertTime;
	private Double salary;
}
