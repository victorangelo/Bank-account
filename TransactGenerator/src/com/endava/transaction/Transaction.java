package com.endava.transaction;

import com.endava.bank.Account;

/**
 * This class designates a Banking Transaction
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
	
	/**
	 * Returns true if the sourceAccount and destinationAccount are different.
	 * @return boolean
	 */
	public boolean validateTransaction(){
		
		if(this.sourceAccount != null || this.destinationAccount != null || 
				(this.sourceAccount.getAccountID().equals(this.destinationAccount.getAccountID()) && 
				this.sourceAccount.getBankID().equals(this.destinationAccount.getBankID()))){
			return false;
		}
		
		return true;
	}
}
