package com.example.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import com.example.springdemo.dao.CustomerDAO;

import com.example.springdemo.entity.Customer;
import com.example.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping("/helloworld")
	public String helloWorld() {
		return "test";
	}

	@GetMapping("/list")
	public String listCustomer(Model theModel) {
		// get customer list from DAO
		List<Customer> customersList = customerService.getCustomers();

		// add customer to the model
		theModel.addAttribute("customers", customersList);
		return "list-customers";
	}
}
