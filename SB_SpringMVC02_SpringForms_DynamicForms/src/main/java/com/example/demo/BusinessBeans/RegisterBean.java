package com.example.demo.BusinessBeans;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RegisterBean {

	private String userName;
	private String userPass;
	private float userSalary;
	private String userGender;
	private String userCountry;
	private String[] userLang;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date userDate;
	private String userAbout;
	private Boolean termsCotd;
}
