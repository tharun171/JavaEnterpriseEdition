package com.learn.orm.Entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
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
@ToString
@NamedQueries(
		value = {
		//get data of employees salary in range
		@NamedQuery(name="query1",
				query="select e from EmployeeEntity e where e.Salary>=?1 and e.Salary<=?2"),
		//get data of employees having some chars in name and sort them descending
		@NamedQuery(name="query2",
		query="select e from EmployeeEntity e where e.employeeName like :subStr order by e.Salary desc"),
		}
		)
public class EmployeeEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="EmpId")
	private Integer employeeId;
	@Column(name="name")
	private String employeeName;
	private String role;
	@Temporal(TemporalType.DATE)
	private Date insertTime;
	@Column(name="salary")
	private Double Salary;
	
}
