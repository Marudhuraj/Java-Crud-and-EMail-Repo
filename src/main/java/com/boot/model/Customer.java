package com.boot.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name ="customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name= "id")
	private long id;
	@Column(name= "name")
	private String name;
	@Column(name= "phone")
	private String phone;
	
	
	public Customer() {
		super();
	}
	public Customer(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private CustomerProfile customerprofile;
	
	public CustomerProfile getCustomerProfile() {
		return this.customerprofile;
	}
	
	public void setCustomerProfile(CustomerProfile customerprofile) {
		this.customerprofile = customerprofile;
	}
}
