package com.boot.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boot.model.Shipwreck;
import com.boot.repository.ShipWreckRepo;

@RestController
@RequestMapping("api/v1")
public class ShipwreckController {
	
	@Autowired
	ShipWreckRepo swr;
	
	@RequestMapping(value = "shipwrecks", method = RequestMethod.GET)
	public List<Shipwreck> list() {
		return swr.findAll();
	}
	
	@RequestMapping(value = "shipwrecks", method = RequestMethod.POST)
	public Shipwreck create(@RequestBody Shipwreck shipwreck) {
		return swr.save(shipwreck);
	}
	
	@RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.GET)
	public Shipwreck get(@PathVariable Long id) {
		return swr.findOne(id);
	}
	
	@RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.PUT)
	public Shipwreck update(@PathVariable Long id, @RequestBody Shipwreck shipwreck) throws Exception {
		Shipwreck shipwreckExisting = swr.findOne(id);
		if(shipwreckExisting == null) {
			throw new Exception();
		}
		//shipwreckExisting.setCondition(shipwreck.getCondition());
		return swr.save(shipwreckExisting);
	}
	
	@RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable Long id) {
		 swr.delete(id);
		return "succuss";
		
	}
}
