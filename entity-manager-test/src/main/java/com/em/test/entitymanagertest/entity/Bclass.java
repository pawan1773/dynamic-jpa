package com.em.test.entitymanagertest.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Bclass implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -377112646755006306L;
	@Id
	@GeneratedValue
	Long id;
	private String code;
	private String description;

	@OneToOne(mappedBy = "bclass")
	Aclass aclass;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Aclass getAclass() {
		return aclass;
	}

	public void setAclass(Aclass aclass) {
		this.aclass = aclass;
	}

}
