package com.em.test.entitymanagertest.service.impl;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.em.test.entitymanagertest.entity.DealerMaster;
import com.em.test.entitymanagertest.entity.VinMaster;
import com.em.test.entitymanagertest.repository.DealerMasterRepository;
import com.em.test.entitymanagertest.repository.VinMasterRepository;
import com.em.test.entitymanagertest.service.VinService;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class VinServiceImplTest {

	@Autowired
	private VinService vinServiceImpl;

	@Autowired
	private VinMasterRepository vinMasterRepository;

	@Autowired
	private DealerMasterRepository dealerMasterRepository;

	@BeforeAll
	public void init() {
		DealerMaster dealerMaster1 = new DealerMaster();
		dealerMaster1.setId(123L);
		dealerMaster1.setDealerCode("dc123");
		dealerMaster1.setDealerName("Joginder");

		DealerMaster dealerMaster2 = new DealerMaster();
		dealerMaster2.setId(246L);
		dealerMaster2.setDealerCode("dc456");
		dealerMaster2.setDealerName("Pawan");

		VinMaster vinMaster = new VinMaster();
		vinMaster.setId(123L);
		vinMaster.setVin("vin0");
		vinMaster.setDealerCode("dc123");
		vinMaster.setDealerSiteCode("sc123");
		vinMaster.setOrderNumber("on123");
		vinMaster.setContractNumber("cn123");

		List<DealerMaster> dealerMasters = Arrays.asList(dealerMaster1, dealerMaster2);

		dealerMasterRepository.saveAll(dealerMasters);

		vinMasterRepository.save(vinMaster);
	}
	
	@Test()
	public void getVinDetailsTest() {
		Exception exception = assertThrows(Exception.class, () -> vinServiceImpl.getVinDetails("vin123"));
		assertTrue(exception.getMessage().contains("test ex"));
	}
	
	@Test()
	public void getVinDetailsTest2() {
		assertDoesNotThrow(() -> vinServiceImpl.getVinDetails("vin0"));
	}
}
