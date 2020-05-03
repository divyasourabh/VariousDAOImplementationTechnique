package com.ds.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ds.springboot.cruddemo.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	//That's it... no need to write any code //
	//If you are using JPA Repository remove all DAO impl :P
}
