package com.em.test.entitymanagertest.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Aclass implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 998723774600323812L;

	@Id
	@GeneratedValue
	Long id;

	@OneToOne
	@JoinColumn(name = "code", referencedColumnName = "code")
	private Bclass bclass;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Bclass getBclass() {
		return bclass;
	}

	public void setBclass(Bclass bclass) {
		this.bclass = bclass;
	}

}
