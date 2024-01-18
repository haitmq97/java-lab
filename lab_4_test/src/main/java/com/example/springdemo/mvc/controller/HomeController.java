package com.example.springdemo.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	
	@RequestMapping("/")
	public String showPage(ModelMap model) {
		model.addAttribute("msg", ". This is from Haitmq");
		
		return "main-menu";
	}

}
