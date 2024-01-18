package com.example.springdemo.dao;

import java.util.List;

import com.example.springdemo.entity.Customer;

public interface CustomerDAO {

	// define method
	public List<Customer> getCustomers();
}
