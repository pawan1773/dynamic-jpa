package com.em.test.entitymanagertest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class VinService {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private VinRepositoryCustom vinRepositoryCustom;

	public void getVinDetails() {
		String vinOrderContractNumber = "on123";
		vinRepositoryCustom.getVinDetails(vinOrderContractNumber, entityManager);
	}
	

}
