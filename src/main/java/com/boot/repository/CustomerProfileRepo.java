package com.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.model.CustomerProfile;

public interface CustomerProfileRepo extends JpaRepository<CustomerProfile, Long> {

}
