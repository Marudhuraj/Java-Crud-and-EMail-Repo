package com.boot.employee.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "salary")
public class EmployeeSalary {
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long id;
		private Integer salary;
		
		public EmployeeSalary() {
			
		}

		public EmployeeSalary(Integer salary) {
			super();
			this.salary = salary;
		}
		
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public Integer getSalary() {
			return salary;
		}
		public void setSalary(Integer salary) {
			this.salary = salary;
		}
		
		
}
