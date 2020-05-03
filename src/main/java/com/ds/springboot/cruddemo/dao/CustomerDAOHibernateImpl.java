package com.ds.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ds.springboot.cruddemo.entity.Customer;

@Repository
public class CustomerDAOHibernateImpl implements CustomerDAO{

	private EntityManager entityManager;
	
	@Autowired
	public CustomerDAOHibernateImpl (EntityManager entityManagerObj) {
		entityManager = entityManagerObj;
	}
	
	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class);
		
		Query<Customer> query = session.createQuery("from Customer",Customer.class);
		
		List<Customer> employees = query.getResultList();
		
		return employees;
	}

	@Override
	public Customer findById(int id) {

		Session session = entityManager.unwrap(Session.class);
		
		Customer customer = session.get(Customer.class,id);
		
		return customer;
	}

	@Override
	public void saveCustomer(Customer customer) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(customer);
	}

	@Override
	public void deleteById(int id) {
		Session session = entityManager.unwrap(Session.class);
		Query<Customer> query = session.createQuery("delete from Customer where id=: customerId");
		query.setParameter("customerId", id);
		query.executeUpdate();
	}

}
