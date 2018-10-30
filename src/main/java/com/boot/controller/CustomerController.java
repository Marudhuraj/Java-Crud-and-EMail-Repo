package com.boot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boot.model.Customer;
import com.boot.model.CustomerProfile;
import com.boot.repository.CustomerProfileRepo;
import com.boot.repository.CustomerRepo;
import com.boot.service.ShipWrekService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private ShipWrekService shipwreck;
	
	@Autowired
	CustomerRepo rp;
	
	@Autowired
	CustomerProfileRepo cpr;
	
	@RequestMapping("/property")
	public Map<String, Object> property() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("message", shipwreck.getMessage());
		map.put("value", shipwreck.getValue());
		map.put("data", shipwreck.getData());
		return map;

	}
	@RequestMapping("/addCustomer")
	private void addcustomer() {
		Customer customer = new Customer("Marudhu","9686491381");
		CustomerProfile cutomerprofile = new CustomerProfile("Bangalore","IT");
		customer.setCustomerProfile(cutomerprofile);
		//cutomerprofile.setCustomer(customer);
		rp.save(customer);
	}
	
	
	@RequestMapping("/findall")
	public List<Customer> findAll() {
		return rp.findAll();
	}
	
	@RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
	public Customer find(@PathVariable Long id) {
		Customer result = rp.findById(id);
		return result;
	}
}
