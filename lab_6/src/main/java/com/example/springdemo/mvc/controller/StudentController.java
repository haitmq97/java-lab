package com.example.springdemo.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.springdemo.mvc.common.Student;

@Controller
@RequestMapping("/student")
public class StudentController {

	// add method to show Student Form
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		
		// add new student object to the model
		theModel.addAttribute("student", new Student());
		
		return "student-form";
	}
	
	// add method tho process thr form
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent) {
		
		// show log student information
		System.out.println("The Student: "+ theStudent.getFirstName()+" "+ theStudent.getLastName());
		
		return "student-comfirmation";
		
	}
}
