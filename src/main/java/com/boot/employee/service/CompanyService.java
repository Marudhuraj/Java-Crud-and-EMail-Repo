package com.boot.employee.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.employee.model.Company;
import com.boot.employee.model.Employee;
import com.boot.employee.repository.CompanyRepository;
import com.boot.employee.repository.EmployeeRepository;

@Service
public class CompanyService {
	
	@Autowired
	public CompanyRepository companyprepo;
	
	public String addCompany(Company cmp) {
		Company iscompanyPresent = companyprepo.findOne(cmp.getId());
		if(iscompanyPresent == null) {
			companyprepo.save(cmp);
			return "Company added successfully";
		}
		return "Company already exist";
	}
	
	public Company getCompany(Long id) {
		return companyprepo.findOne(id);
	}
	
	public List<Company> getAllCompany() {
		return (List<Company>) companyprepo.findAll();
	}
	
	public void deleteCompany(Long cmpid) {
		companyprepo.delete(cmpid);
	}
}
