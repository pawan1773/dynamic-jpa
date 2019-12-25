package com.em.test.entitymanagertest.repository;

import javax.persistence.EntityManager;

public interface VinRepositoryCustom {

	void getVinDetails(String vinOrderContractNumber, EntityManager entityManager);

}
