package com.example.demo.learn.Beans;

import java.util.Date;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RegisterBean {

	@NotEmpty
	@Size(min=6,max=10,message="Name should be between 6 and 10 char long")
	private String username;
	@NotEmpty(message="password.required")
	@Size(min=6,max=10)
	private String password;
	@NotEmpty
	private String gender;
	@NotEmpty
	private String country;
	@NotEmpty
	@Size(min=6)
	private String aboutYou;
	@Size(min=2)
	private String[] language;
	@AssertTrue
	private boolean mailingList;
	
	@NotNull
	@Range(min=18,max=50)
	private Integer age;
	@NotNull
	@Range(min=15000,max=80000)
	private Integer salary;
	@NotNull
	@Future
	@DateTimeFormat(pattern="dd-MMM-yyyy")
	//22-Feb-2023
	private Date joiningDate;
}
