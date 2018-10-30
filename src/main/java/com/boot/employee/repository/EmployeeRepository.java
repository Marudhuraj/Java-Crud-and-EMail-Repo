package com.boot.employee.repository;

import org.springframework.data.repository.CrudRepository;

import com.boot.employee.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
