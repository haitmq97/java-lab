package com.example.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springdemo.dao.CustomerDAO;

import com.example.springdemo.entity.Customer;
import com.example.springdemo.service.CustomerService;

import javassist.expr.NewArray;

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
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create a customer object and add it to model
		theModel.addAttribute("customer", new Customer());
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		// save customer
		customerService.saveCustomer(theCustomer);
		
		return "redirect:/customer/list";	
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {
		// get customer as a model attribute to pre-populate the form
		Customer theCustomer = customerService.getCustomer(theId);
		
		// set custoemr as a model attribute to pre-Populate the form
		theModel.addAttribute("customer", theCustomer);
		
		//send over to form
		return "customer-form";
	}
	
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId") int theId) {
		
		customerService.deleteCustomer(theId);
		
		return "redirect:/customer/list";
	}
	
		
}
