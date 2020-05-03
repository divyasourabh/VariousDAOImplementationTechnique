package com.ds.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ds.springboot.cruddemo.entity.Customer;

@Repository
public class CustomerDAOJPAImpl implements CustomerDAO{

	private EntityManager entityManager;

	@Autowired	
	public CustomerDAOJPAImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Customer> findAll() {
		Query query = entityManager.createQuery("from Customer");

		List<Customer> employees = query.getResultList();

		return employees;
	}

	@Override
	public Customer findById(int id) {

		Customer customer = entityManager.find(Customer.class, id);
		return customer;
	}

	@Override
	public void saveCustomer(Customer customer) {
		// save or update the customer
		customer.setId(0);

		Customer customerNew = entityManager.merge(customer);

		// update with id from db ... so we can get generated id for save/insert
		customer.setId(customerNew.getId());		
	}

	@Override
	public void deleteById(int id) {
		// delete object with primary key
		Query theQuery = entityManager.createQuery(
							"delete from Customer where id=:customerId");
		
		theQuery.setParameter("customerId", id);
		
		theQuery.executeUpdate();
	}

}
