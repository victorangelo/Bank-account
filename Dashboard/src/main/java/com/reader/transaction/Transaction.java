package com.reader.transaction;

import com.reader.bank.Account;

/**
 * This class designates a Banking Transaction by the XML DOM.
 * 
 * @author Victor Angheluta.
 */
public class Transaction {

	private double transactionValue;
	private Account sourceAccount;
	private Account destinationAccount;

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
