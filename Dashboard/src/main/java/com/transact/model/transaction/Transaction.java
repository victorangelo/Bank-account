package com.transact.model.transaction;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.transact.model.bank.Account;

@Entity
@Table(name = "transation")
public class Transaction {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	Long ID;
	
	@Column(name="value")
	double transactionValue;
	
	@Column(name="sourceAccountID")
	Account sourceAccount;
	
	@Column(name="destinationAccountID")
	Account destinationAccount;

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public double getTransactionValue() {
		return transactionValue;
	}

	public void setTransactionValue(double transactionValue) {
		this.transactionValue = transactionValue;
	}

	public Account getSourceAccount() {
		return sourceAccount;
	}

	public void setSourceAccount(Account sourceAccount) {
		this.sourceAccount = sourceAccount;
	}

	public Account getDestinationAccount() {
		return destinationAccount;
	}

	public void setDestinationAccount(Account destinationAccount) {
		this.destinationAccount = destinationAccount;
	}
}
