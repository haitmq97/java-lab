package com.example.springdemo.dao;

import java.util.List;

import com.example.springdemo.entity.Customer;

public interface CustomerDAO {

	// define method
	
	// get customer list
	public List<Customer> getCustomers();
	
	
	// get customer by id
	public Customer getCustomer(int theId);
	
	// save or update custoemr
	public void saveCustomer(Customer theCustomer);
	
	// delete customer
	public void deleteCustomer(int theId);
}
