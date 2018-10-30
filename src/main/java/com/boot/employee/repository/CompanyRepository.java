package com.boot.employee.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.boot.employee.model.Company;

public interface CompanyRepository extends CrudRepository<Company, Long> {
	
}
