package com.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boot.employee.service.EmailService;
import com.boot.model.Login;
import com.boot.model.Test;
import com.boot.repository.userRepo;
import com.fasterxml.jackson.databind.util.JSONPObject;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class LoginController {
		
	@Autowired
	private userRepo userrp;
	
	@Autowired
	private EmailService email;
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public Test register(@RequestBody Login userRegister) {
		Login isRegistered = userrp.findByUserid(userRegister.getUserid());
		Test test = new Test();
		if(isRegistered == null) {
			Boolean emailsend = email.sendEmail(userRegister.getUserid());
			if(emailsend) {
				userrp.save(userRegister);
				test.setMessage("User registerd and Eail successfully");
				test.setSuccess("Success");
			} else {
				test.setMessage("Email not send");
				test.setSuccess("Email Error");
			}
			
		} else {
			test.setMessage("User already registerd");
			test.setSuccess("Error");
		}
		
		return test;
	}
	
	@RequestMapping(value= "/login", method = RequestMethod.POST)
	public Test login(@RequestBody Login user) {
		Login isUser = userrp.findByUserid(user.getUserid());
		
		Test test = new Test();
		test.setMessage("User already login");
		test.setSuccess("Success");
		return test;
	}
}
