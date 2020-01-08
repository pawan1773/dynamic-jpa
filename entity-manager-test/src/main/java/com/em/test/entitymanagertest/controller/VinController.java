package com.em.test.entitymanagertest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.em.test.entitymanagertest.entity.Aclass;
import com.em.test.entitymanagertest.repository.AclassRepository;

@RestController
@RequestMapping("/vin")
public class VinController {
	
	//@Autowired
	//private VinService vinServiceImpl;
	
	@Autowired
	private AclassRepository aclassRepository;
	
	@GetMapping
	public String getVinDetails() throws Exception {
			
		
		List<Aclass> aclassList = aclassRepository.findAll();
		
		System.out.println(aclassList.get(0).getBclass().getDescription());
		
		//vinServiceImpl.getVinDetails("vin");
		return "Success";
	}

}
