package com.transact.model.bank;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The class designates the persistent object for a Bank mapped Entity.
 * 
 * @author Victor Angheluta
 */
@Entity
@Table(name = "bank")
public class BankEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@GeneratedValue
	@Id
	Integer id;
    
	String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
