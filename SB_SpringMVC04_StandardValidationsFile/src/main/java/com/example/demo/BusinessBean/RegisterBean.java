package com.example.demo.BusinessBean;

import java.util.Date;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
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
public class RegisterBean {

	@NotEmpty
	@Size(min=6,max=12)
	private String userName;
	@NotEmpty
	@Size(min=6,max=10)
	private String userPass;
	@NotNull
	@Range(min=10000,max=99999)
	private float userSalary;
	@NotEmpty
	private String userGender;
	@NotEmpty
	private String userCountry;
	@NotEmpty
	@Size(min=2,max=2)
	private String[] userLang;
	@NotNull
	@PastOrPresent
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date userDate;
	@NotEmpty
	@Size(min=12,max=30)
	private String userAbout;
	@AssertTrue
	private Boolean termsCotd;
}
