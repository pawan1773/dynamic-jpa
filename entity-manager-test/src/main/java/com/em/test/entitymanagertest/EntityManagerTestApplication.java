package com.em.test.entitymanagertest;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.em.test.entitymanagertest.entity.DealerMaster;
import com.em.test.entitymanagertest.entity.VinMaster;
import com.em.test.entitymanagertest.repository.DealerMasterRepository;
import com.em.test.entitymanagertest.repository.VinMasterRepository;

@SpringBootApplication
public class EntityManagerTestApplication implements CommandLineRunner {

	@Autowired
	private VinMasterRepository vinMasterRepository;

	@Autowired
	private DealerMasterRepository dealerMasterRepository;

	public static void main(String[] args) {
		SpringApplication.run(EntityManagerTestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		DealerMaster dealerMaster1 = new DealerMaster();
		dealerMaster1.setDealerCode("dc123");
		dealerMaster1.setDealerName("Joginder");

		DealerMaster dealerMaster2 = new DealerMaster();
		dealerMaster2.setDealerCode("dc456");
		dealerMaster2.setDealerName("Pawan");
		
		VinMaster vinMaster = new VinMaster();
		vinMaster.setVin("vin123");
		vinMaster.setDealerCode("dc123");
		vinMaster.setDealerSiteCode("sc123");
		vinMaster.setOrderNumber("on123");
		vinMaster.setContractNumber("cn123");
		
		List<DealerMaster> dealerMasters = Arrays.asList(dealerMaster1, dealerMaster2);
		
		dealerMasterRepository.saveAll(dealerMasters);
		
		vinMasterRepository.save(vinMaster);

	}

}
