package com.boot.employee.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String designation;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "salary_id")
	private EmployeeSalary empsalary;

	
	public Employee() {
	
	}
	public Employee(String name, String designation) {
		super();
		this.name = name;
		this.designation = designation;
	}
	
	public Employee(String name, String designation, EmployeeSalary empsalary) {
		super();
		this.name = name;
		this.designation = designation;
		this.empsalary = empsalary;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	
	public EmployeeSalary getSalary() {
		return empsalary;
	}
	public void setSalary(EmployeeSalary salary) {
		this.empsalary = salary;
	}
}
