package com.learn.spring.Entities;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name="Employee_Data_1")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeEntity {

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="entity_Seq")
	//no seperate name for sequence table
	//same name as generator name used to create another table for sequence
	@SequenceGenerator(name="entity_Seq",initialValue = 1001,allocationSize = 1)
	//creating a seperate taale for sequence
	//@SequenceGenerator(name="entity_Seq",sequenceName ="employeedata1Seq",initialValue = 1001,allocationSize = 1)
	@Column(name="empid")
	private Integer empId;
	@Column(name="name")
	private String empName;
	@Column(name="role")
	private String empRole;
	@Column(name="salary")
	private Float empSalary;
	@Column(name="inserttime")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
	private Date insertTime;

}
