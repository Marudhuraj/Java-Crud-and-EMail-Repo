package com.boot.employee.repository;

import org.springframework.data.repository.CrudRepository;

import com.boot.employee.model.EmployeeSalary;

public interface EmployeeSalaryRepository extends CrudRepository<EmployeeSalary, Long> {

}
