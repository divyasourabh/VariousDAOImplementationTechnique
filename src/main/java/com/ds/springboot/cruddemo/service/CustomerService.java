package com.ds.springboot.cruddemo.service;

import java.util.List;

import com.ds.springboot.cruddemo.entity.Customer;

public interface CustomerService {
	public List<Customer> findAll();
	
	public Customer findById(int id);
	
	public void saveCustomer(Customer customer);
	
	public void deleteById(int id);
}
