package com.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long> {
	
	Customer findById(Long id);

}
