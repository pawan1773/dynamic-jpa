package com.em.test.entitymanagertest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.em.test.entitymanagertest.service.VinService;

@RestController
@RequestMapping("/vin")
public class VinController {
	
	@Autowired
	private VinService vinService;
	
	@GetMapping
	public String getVinDetails() {
		vinService.getVinDetails();
		return "Success";
	}

}