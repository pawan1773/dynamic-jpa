package com.em.test.entitymanagertest.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.em.test.entitymanagertest.dto.VinDto;
import com.em.test.entitymanagertest.repository.VinRepositoryCustom;
import com.em.test.entitymanagertest.service.VinService;

@Service
@Transactional
public class VinServiceImpl implements VinService {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private VinRepositoryCustom vinRepositoryCustom;

	@Override
	public void getVinDetails() {
		String vinOrderContractNumber = "vin123";
		@SuppressWarnings("unused")
		List<VinDto> vinDtos = vinRepositoryCustom.getVinDetails(vinOrderContractNumber, entityManager);
	}
	

}
