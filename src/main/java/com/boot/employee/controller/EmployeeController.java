package com.boot.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boot.employee.formbeans.EmployeeFormBean;
import com.boot.employee.model.Employee;
import com.boot.employee.repository.EmployeeSalaryRepository;
import com.boot.employee.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService empservice;
		
	@RequestMapping(value = "/employee/add", method=RequestMethod.POST)
	public void addEmployee(@RequestBody EmployeeFormBean employeeFormBean) {
		empservice.addEmployee(employeeFormBean);
	}
	
	@RequestMapping(value = "/employee/getall", method=RequestMethod.GET)
	public List<Employee> getAllEmployee() {
		return empservice.getAllEmployee();
	}
	
	@RequestMapping(value = "/employee/{id}", method=RequestMethod.GET)
	public Employee getEmployee(@PathVariable Long id) {
		return empservice.getEmployee(id);
	}
	
	@RequestMapping(value = "/employee/{id}", method=RequestMethod.DELETE)
	public void deleteEmployee(@PathVariable Long id) {
		empservice.deleteEmployee(id);
	}
}
