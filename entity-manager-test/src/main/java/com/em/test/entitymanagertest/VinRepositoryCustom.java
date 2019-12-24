package com.em.test.entitymanagertest;

import javax.persistence.EntityManager;

public interface VinRepositoryCustom {

	void getVinDetails(String vinOrderContractNumber, EntityManager entityManager);

}
