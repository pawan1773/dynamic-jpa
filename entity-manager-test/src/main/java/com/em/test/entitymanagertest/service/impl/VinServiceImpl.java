package com.em.test.entitymanagertest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.em.test.entitymanagertest.dto.VinDto;
import com.em.test.entitymanagertest.repository.VinRepositoryCustom;
import com.em.test.entitymanagertest.service.VinService;

@Service
@Transactional
public class VinServiceImpl implements VinService {	
	
	@Autowired
	@Qualifier(value = "vinRepositoryCustomImpl")
	private VinRepositoryCustom vinRepositoryCustom;
	
	@Autowired
	private Environment environment;	

	public VinServiceImpl(VinRepositoryCustom vinRepositoryCustom, Environment environment) {
		super();
		this.vinRepositoryCustom = vinRepositoryCustom;
		this.environment = environment;
	}



	@Override
	public void getVinDetails() throws Exception {
		String vinOrderContractNumber = "vin123";
		List<VinDto> vinDtos = vinRepositoryCustom.getVinDetails(vinOrderContractNumber);
		if(vinDtos == null || vinDtos.isEmpty()) {
			throw new Exception(environment.getProperty("ex.msg"));
		}
	}
	

}
