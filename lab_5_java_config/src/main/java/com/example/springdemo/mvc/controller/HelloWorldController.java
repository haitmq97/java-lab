package com.example.springdemo.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

	
	// add method to show the initial HTML form
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	
	// let comment this method for lab5.1 purpose
	/*
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
	
	*/
	
	// updata process method versio 3
	@RequestMapping("/processFormVersionThree")
	public String letsShoutDude(@RequestParam("studentName") String theName, ModelMap model) {
		
		
		// converter data into Upper-case
		
		theName = theName.toUpperCase();
		
		// create the message
		
		String result = "Hey My Friend from v3! " + theName;
		
		// add result to model
		
		model.addAttribute("message",result);
		
		return "helloworld";
	}
	
}
