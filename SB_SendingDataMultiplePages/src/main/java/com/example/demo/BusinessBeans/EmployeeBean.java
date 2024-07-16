package com.example.demo.BusinessBeans;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
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

	@NotEmpty
	private String firstName;
	@NotEmpty
	private String lastName;
	@NotEmpty
	private String email;
	@NotEmpty
	@Size(min=6,max=9)
	private String password;
	@DateTimeFormat(pattern ="dd-MM-yyyy")
	@Past
	@NotNull
	private Date dob;
	@NotEmpty
	private String country;
	@NotEmpty
	@Size(min = 2)
	private String[] language;
	@NotEmpty
	private String gender;
	@NotEmpty
	private String aboutYou;
	@AssertTrue
	private boolean termsAndCotd;
}
