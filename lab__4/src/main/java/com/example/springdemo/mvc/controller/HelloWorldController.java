package com.example.springdemo.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

	
	// add method to show the initial HTML form
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	// add method to process the HTML form
	
	// let comment here for lab 4.6 purpose
	/*
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	*/
	
	// add a method to read form data and add data to model
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, ModelMap model) {
		
		// read data from HTML form by request parameter
		String theName = request.getParameter("studentName");
		
		// converter data into Upper-case
		
		theName = theName.toUpperCase();
		
		// create the message
		
		String result = "Yo! " + theName;
		
		// add result to model
		
		model.addAttribute("message",result);
		
		return "helloworld";
	}
}
