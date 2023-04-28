package com.rbu.ecp.dao;

import com.rbu.ecp.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByEmail(String theEmail);  //Behind the scenes, Spring executes the query similar to this (select * from customer c where c.email = theEmail) this method returns null if not found
}
