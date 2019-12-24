package com.em.test.entitymanagertest;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Tuple;

import org.springframework.stereotype.Repository;

@Repository
public class VinRepositoryCustomImpl implements VinRepositoryCustom {

	@Override
	public void getVinDetails(String vinOrderContractNumber, EntityManager entityManager) {

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

		List<Tuple> tuples = entityManager.createQuery(queryBuilder.toString(), Tuple.class)
				.setParameter("input", vinOrderContractNumber).getResultList();

		List<VinDto> vinDtos = new ArrayList<>();
		for (Tuple tuple : tuples) {

			VinDto vinDto = new VinDto();
			vinDto.setVin(tuple.get("vin", String.class));
			vinDto.setDealerCode(tuple.get("dc", String.class));
			vinDto.setDealerName(tuple.get("dn", String.class));

			vinDtos.add(vinDto);
		}

		for (VinDto vinDto : vinDtos) {
			System.out.println("vin ===> " + vinDto.getVin());
			System.out.println("dealer code ===> " + vinDto.getDealerCode());
			System.out.println("dealer Name ===> " + vinDto.getDealerName());
		}

	}

}
