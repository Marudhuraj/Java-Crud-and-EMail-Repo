package com.boot.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.employee.formbeans.EmployeeFormBean;
import com.boot.employee.model.Employee;
import com.boot.employee.model.EmployeeSalary;
import com.boot.employee.repository.EmployeeRepository;
import com.boot.employee.repository.EmployeeSalaryRepository;

@Service
public class EmployeeService {
	
	@Autowired
	public EmployeeRepository emprepo;
	
	@Autowired
	EmployeeSalaryRepository salaryrep;
	
	public String addEmployee(EmployeeFormBean employeeFormBean) {
		Employee empObj = new Employee();
		empObj.setName(employeeFormBean.getName());
		empObj.setDesignation(employeeFormBean.getDesignation());
		EmployeeSalary empSalaryObj = new EmployeeSalary();
		empSalaryObj.setSalary(employeeFormBean.getEmployeeSalaryBean().getSalary());
		empObj.setSalary(empSalaryObj);
		if(empObj.getName() != null) {
			emprepo.save(empObj);
			if(empSalaryObj != null) {
				salaryrep.save(empSalaryObj);
			}
			return "Employee added successfully";
		}
		return "Employee already exist";
	}
	
	public Employee getEmployee(Long empId) {
		return emprepo.findOne(empId);
	}
	
	public List<Employee> getAllEmployee() {
		return (List<Employee>) emprepo.findAll();
	}
	
	public void deleteEmployee(Long empId) {
		emprepo.delete(empId);
	}
}
