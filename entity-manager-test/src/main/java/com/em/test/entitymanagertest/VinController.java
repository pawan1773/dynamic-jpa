package com.em.test.entitymanagertest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vin")
public class VinController {
	
	@Autowired
	private VinService vinService;
	
	@GetMapping
	public void getVinDetails() {
		vinService.getVinDetails();
	}

}
