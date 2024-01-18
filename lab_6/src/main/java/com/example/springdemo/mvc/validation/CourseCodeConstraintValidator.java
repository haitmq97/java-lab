package com.example.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String>{

	
	private String coursePrefix;
	
	

	@Override
	public void initialize(CourseCode theCourseCode) {
		// TODO Auto-generated method stub
		coursePrefix = theCourseCode.value();
	}
	




	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext constraintValidatorContext) {
		// TODO Auto-generated method stub
		
		//flag
		boolean result;
		
		System.out.println("|" + theCode+ "|");
		
		System.out.println("===>>> is the code null: " + (theCode == null));
		
		// when not typed anything in field theCode is not null
		if(theCode.isBlank()) {
			return true;
		}
		
		
		
		// logic check 
		if (theCode != null) {
			result = theCode.startsWith(coursePrefix);
			
		} else {
			//because this field is not require
			
			result = true;
		}
		
		return result;
	}
	
	

	
}
