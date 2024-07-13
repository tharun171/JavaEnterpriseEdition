package com.Jdbc.Entities;

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
public class EmployeeEntity {

	private Integer EmpId;
	private String EmpName;
	private String EmpEmail;
	private String EmpPassword;
}
