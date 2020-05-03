package com.ds.springboot.cruddemo.rest;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ds.springboot.cruddemo.dao.CustomerDAO;
import com.ds.springboot.cruddemo.entity.Customer;
import com.ds.springboot.cruddemo.service.CustomerService;

@RestController
@RequestMapping("/jpa/api")
public class CustomerJPARestController {

	private CustomerService customerService;
	
	@Autowired
	public CustomerJPARestController (@Qualifier("customerJPAServiceImpl") CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@GetMapping("/customers")
	public List<Customer> findAll(){
		return customerService.findAll();
	}
	
	@GetMapping("/customers/{customerId}")
	public Customer findById(@PathVariable int customerId){
		Customer customer = customerService.findById(customerId);
		if (customer == null) {
			throw new RuntimeException("Employee id not found= " + customerId);
		}
		return customer;
	}
	
	
	@PostMapping("/customers")
	public Customer saveCustomer(@RequestBody Customer customer){
		customer.setId(0);
		customerService.saveCustomer(customer);
		return customer;
	}
	
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer customer){
		customerService.saveCustomer(customer);
		return customer;
	}

	@DeleteMapping("/customers/{customerId}")
	public String deleteCustomer(@PathVariable int customerId){
		Customer customer = customerService.findById(customerId);
		if (customer == null) {
			throw new RuntimeException("Employee id not found= " + customerId);
		}
		
		customerService.deleteById(customerId);
		
		return "Customer Id: " + customerId + " Deleted !";
	}
}
