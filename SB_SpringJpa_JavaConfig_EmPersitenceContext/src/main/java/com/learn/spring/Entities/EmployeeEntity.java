package com.learn.spring.Entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="employee_data_1")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int empId;
	private String name;
	private String role;
	@Temporal(TemporalType.DATE)
	private Date insertTime;
	private Double salary;
	@Override
	public String toString() {
		return "\nEmployeeEntity [empId=" + empId + ", name=" + name + ", role=" + role + ", insertTime=" + insertTime
				+ ", salary=" + salary + "]";
	}
	
	
	
}
