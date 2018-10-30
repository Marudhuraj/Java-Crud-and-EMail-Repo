package com.boot.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boot.employee.model.Company;
import com.boot.employee.model.Employee;
import com.boot.employee.service.CompanyService;
import com.boot.employee.service.EmployeeService;

@RestController
public class CompanyController {
	
	@Autowired
	CompanyService companyservice;
	
	@RequestMapping(value = "/company/add", method=RequestMethod.POST)
	public void addEmployee(@RequestBody Company cmp) {
		companyservice.addCompany(cmp);
	}
	
	@RequestMapping(value = "/company/getall", method=RequestMethod.GET)
	public List<Company> getAllEmployee() {
		return companyservice.getAllCompany();
	}
	
	@RequestMapping(value = "/company/{id}", method=RequestMethod.GET)
	public Company getEmployee(@PathVariable Long id) {
		return companyservice.getCompany(id);
	}
	
	@RequestMapping(value = "/employee/{empid}/company/{id}", method=RequestMethod.DELETE)
	public void deleteEmployee(@PathVariable Long id) {
		companyservice.deleteCompany(id);
	}
}
