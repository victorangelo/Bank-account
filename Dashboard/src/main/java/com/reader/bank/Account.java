package com.reader.bank;
/**
 * This class designates a Bank Account by the XML DOM.
 * 
 * @author Victor Angheluta.
 */
public class Account {

	private String accountID;
	private String bankID;
	
	public Account() {
	}
	public Account(String accountID, String bankID){
		this.accountID = accountID;
		this.bankID = bankID;
	}
	public String getAccountID() {
		return accountID;
	}
	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}
	public String getBankID() {
		return bankID;
	}
	public void setBankID(String bankID) {
		this.bankID = bankID;
	}
}
