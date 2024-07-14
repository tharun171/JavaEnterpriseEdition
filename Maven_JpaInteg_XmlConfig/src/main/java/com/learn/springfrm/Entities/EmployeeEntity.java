package com.learn.springfrm.Entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="employeeMavenJpaIntegration")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeEntity {

	@Id
	@SequenceGenerator(name="employee1_seq",
	initialValue = 1001,allocationSize = 1)
	@GeneratedValue(strategy =GenerationType.SEQUENCE,
	generator="employee1_seq")
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Id")
	private Integer empId;
	@Column(name="Name")
	private String empName;
	@Column(name="Gender")
	private Character empGender;
	@Column(name="Role")
	private String empRole;
	@Column(name="Salary")
	private Double empSalary;
	@Column(name="JoinedDate")
	//@DateTimeFormat(pattern = "dd-MMM-yyyy")
	//getting 0000 in time, we use this in spring boot
	//in jpa we use Temporal - used to indicate that date part will be entering Db
	@Temporal(TemporalType.DATE)
	private Date empJoined;
}
