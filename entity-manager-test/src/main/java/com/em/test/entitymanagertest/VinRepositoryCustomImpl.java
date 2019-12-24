package com.em.test.entitymanagertest;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

@Repository
public class VinRepositoryCustomImpl implements VinRepositoryCustom {

	@Override
	public void getVinDetails(String vinOrderContractNumber, EntityManager entityManager) {

		String fields = "vinMaster.vin, vinMaster.dealerCode, dealerMaster.dealerName ";
		String tables = "VinMaster vinMaster, DealerMaster dealerMaster ";

		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("select ");
		queryBuilder.append(fields);
		queryBuilder.append("from ");
		queryBuilder.append(tables);
		queryBuilder.append("where ");
		queryBuilder.append(
				"vinMaster.dealerCode = dealerMaster.dealerCode and (vinMaster.vin=:input or vinMaster.contractNumber=:input or vinMaster.orderNumber=:input)");

		TypedQuery<Object[]> query = entityManager.createQuery(queryBuilder.toString(), Object[].class);
		query.setParameter("input", vinOrderContractNumber);

		List<Object[]> results = query.getResultList();

		List<VinDto> vinDtos = new ArrayList<>();
		for (Object[] row : results) {
			VinDto vinDto = new VinDto();
			vinDto.setVin(row[0].toString());
			vinDto.setDealerCode(row[1].toString());
			vinDto.setDealerName(row[2].toString());

			vinDtos.add(vinDto);
		}

		for (VinDto vinDto : vinDtos) {
			System.out.println(vinDto.getDealerName());
		}

	}

}
