package com.boot.employee.formbeans;

public class EmployeeFormBean {
	
	private String name;
	private String designation;
	private EmployeeSalaryFormBean employeeSalaryBean;
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
	public EmployeeSalaryFormBean getEmployeeSalaryBean() {
		return employeeSalaryBean;
	}
	public void setEmployeeSalaryBean(EmployeeSalaryFormBean employeeSalaryBean) {
		this.employeeSalaryBean = employeeSalaryBean;
	}
	
	
	

}
