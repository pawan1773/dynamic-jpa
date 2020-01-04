package com.em.test.entitymanagertest.repository.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Tuple;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.em.test.entitymanagertest.dto.VinDto;
import com.em.test.entitymanagertest.repository.VinRepositoryCustom;

@Qualifier(value = "vinRepositoryCustomImpl")
@Repository
public class VinRepositoryCustomImpl implements VinRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;
	
	public VinRepositoryCustomImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<VinDto> getVinDetails(String vinOrderContractNumber) {

		String fields = "select vinMaster.vin as vin, vinMaster.dealerCode as dc, dealerMaster.dealerName as dn ";
		String tables = "from VinMaster vinMaster, DealerMaster dealerMaster ";

		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append(fields);
		queryBuilder.append(tables);
		queryBuilder.append(
				"where vinMaster.dealerCode = dealerMaster.dealerCode and (vinMaster.vin=:input or vinMaster.contractNumber=:input or vinMaster.orderNumber=:input)");

		return entityManager.createQuery(queryBuilder.toString(), Tuple.class)
				.setParameter("input", vinOrderContractNumber).getResultList().stream().map(tuple -> {
					VinDto vinDto = new VinDto();
					vinDto.setVin(tuple.get("vin", String.class));
					vinDto.setDealerCode(tuple.get("dc", String.class));
					vinDto.setDealerName(tuple.get("dn", String.class));
					return vinDto;
				}).collect(Collectors.toList());

	}

}
