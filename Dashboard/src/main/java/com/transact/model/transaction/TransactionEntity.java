package com.transact.model.transaction;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.transact.model.bank.AccountEntity;

/**
 * The class designates the persistent object for a Transaction mapped Entity.
 * 
 * @author Victor Angheluta
 */
@Entity
@Table(name = "transaction")
public class TransactionEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@GeneratedValue
	@Id
	Integer id;
	
	double value;
	
	@ManyToOne
	@JoinColumn(name="sourceAccountID")
	AccountEntity sourceAccountID;
	
	@ManyToOne
	@JoinColumn(name="destinationAccountID")
	AccountEntity destinationAccountID;

	Date date;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public AccountEntity getSourceAccountID() {
		return sourceAccountID;
	}

	public void setSourceAccountID(AccountEntity sourceAccountID) {
		this.sourceAccountID = sourceAccountID;
	}

	public AccountEntity getDestinationAccountID() {
		return destinationAccountID;
	}

	public void setDestinationAccountID(AccountEntity destinationAccountID) {
		this.destinationAccountID = destinationAccountID;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
