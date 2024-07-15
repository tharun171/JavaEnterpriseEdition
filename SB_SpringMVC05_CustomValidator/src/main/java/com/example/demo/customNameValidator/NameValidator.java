package com.example.demo.customNameValidator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NameValidator implements
ConstraintValidator<NameValidatorVal,String>{

	@Override
	public boolean isValid(String name, ConstraintValidatorContext arg1) {
		
		if(name==null)
			return false;
		if(name.length()<6)
			return false;
		else
			return true;
		
	}
}
