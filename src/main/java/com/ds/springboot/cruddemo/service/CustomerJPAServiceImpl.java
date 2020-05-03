package com.ds.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ds.springboot.cruddemo.dao.CustomerDAO;
import com.ds.springboot.cruddemo.dao.CustomerRepository;
import com.ds.springboot.cruddemo.entity.Customer;

@Service
public class CustomerJPAServiceImpl implements CustomerService{

	private CustomerRepository customerRepository;
	
	@Autowired
	public CustomerJPAServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	@Override
	public Customer findById(int id) {
		// TODO Auto-generated method stub
		Optional<Customer> result = customerRepository.findById(id);
		
		Customer customer = null;
		
		if (result.isPresent()) {
			customer = result.get();
		} else {
			throw new RuntimeException("Did not find customer id= " + id);
		}
		
		return customer;
	}

	@Override
	public void saveCustomer(Customer customer) {
		customerRepository.save(customer);
		
	}

	@Override
	public void deleteById(int id) {
		customerRepository.deleteById(id);
	}

}
