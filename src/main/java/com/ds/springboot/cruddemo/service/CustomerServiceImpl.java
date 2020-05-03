package com.ds.springboot.cruddemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ds.springboot.cruddemo.dao.CustomerDAO;
import com.ds.springboot.cruddemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{

	private CustomerDAO customerDAO;
	
	@Autowired
	public CustomerServiceImpl(@Qualifier("customerDAOJPAImpl") CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}
	
	@Override
	@Transactional
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return customerDAO.findAll();
	}

	@Override
	@Transactional
	public Customer findById(int id) {
		// TODO Auto-generated method stub
		return customerDAO.findById(id);
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		customerDAO.saveCustomer(customer);
		
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		customerDAO.deleteById(id);
	}

}
