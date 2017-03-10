package com.transact.model.bank;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The class designates the persistent object for an Account mapped Entity.
 * 
 * @author Victor Angheluta
 */
@Entity
@Table(name = "account")
public class AccountEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	@GeneratedValue
	@Id
	private Integer id;
	
	private String number;
	
	private Double balance;
	
	@ManyToOne
	@JoinColumn(name="bankID")
	private BankEntity bankID;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public BankEntity getBankID() {
		return bankID;
	}

	public void setBankID(BankEntity bankID) {
		this.bankID = bankID;
	}
}
