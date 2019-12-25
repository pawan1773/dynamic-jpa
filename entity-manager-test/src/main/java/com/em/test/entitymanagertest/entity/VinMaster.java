package com.em.test.entitymanagertest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class VinMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String vin;

	private String orderNumber;

	private String contractNumber;

	private String dealerCode;

	private String dealerSiteCode;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getContractNumber() {
		return contractNumber;
	}

	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
	}

	public String getDealerCode() {
		return dealerCode;
	}

	public void setDealerCode(String dealerCode) {
		this.dealerCode = dealerCode;
	}

	public String getDealerSiteCode() {
		return dealerSiteCode;
	}

	public void setDealerSiteCode(String dealerSiteCode) {
		this.dealerSiteCode = dealerSiteCode;
	}

}
