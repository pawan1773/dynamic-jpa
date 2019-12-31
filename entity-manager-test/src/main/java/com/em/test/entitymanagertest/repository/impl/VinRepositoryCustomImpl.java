package com.em.test.entitymanagertest.repository.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.Tuple;

import org.springframework.stereotype.Repository;

import com.em.test.entitymanagertest.dto.VinDto;
import com.em.test.entitymanagertest.repository.VinRepositoryCustom;

@Repository
public class VinRepositoryCustomImpl implements VinRepositoryCustom {

	@Override
	public List<VinDto> getVinDetails(String vinOrderContractNumber, EntityManager entityManager) {

		String fields = "vinMaster.vin as vin, vinMaster.dealerCode as dc, dealerMaster.dealerName as dn ";
		String tables = "VinMaster vinMaster, DealerMaster dealerMaster ";

		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("select ");
		queryBuilder.append(fields);
		queryBuilder.append("from ");
		queryBuilder.append(tables);
		queryBuilder.append("where ");
		queryBuilder.append(
				"vinMaster.dealerCode = dealerMaster.dealerCode and (vinMaster.vin=:input or vinMaster.contractNumber=:input or vinMaster.orderNumber=:input)");

		return entityManager.createQuery(queryBuilder.toString(), Tuple.class)
				.setParameter("input", vinOrderContractNumber)
				.getResultList()
				.stream()
				.map(tuple -> {
					VinDto vinDto = new VinDto();
					vinDto.setVin(tuple.get("vin", String.class));
					vinDto.setDealerCode(tuple.get("dc", String.class));
					vinDto.setDealerName(tuple.get("dn", String.class));
					return vinDto;
				}).collect(Collectors.toList());
				
	}

}
