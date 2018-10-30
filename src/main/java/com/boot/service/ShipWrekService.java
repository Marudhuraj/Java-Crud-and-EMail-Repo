package com.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.boot.model.Shipwreck;
import com.boot.repository.ShipWreckRepo;

@Service
@ConfigurationProperties("basic")
public class ShipWrekService {
	private String message;
	private int value;
	private Boolean data;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Boolean getData() {
		return data;
	}

	public void setData(Boolean data) {
		this.data = data;
	}

	@Autowired
	ShipWreckRepo swr;

	public List<Shipwreck> list() {
		return swr.findAll();
	}


}
