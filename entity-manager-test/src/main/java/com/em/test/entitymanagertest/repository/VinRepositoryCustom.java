package com.em.test.entitymanagertest.repository;

import java.util.List;

import javax.persistence.EntityManager;

import com.em.test.entitymanagertest.dto.VinDto;

public interface VinRepositoryCustom {

	List<VinDto> getVinDetails(String vinOrderContractNumber, EntityManager entityManager);

}
