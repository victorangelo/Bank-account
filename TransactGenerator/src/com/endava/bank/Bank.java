package com.endava.bank;

import java.util.ArrayList;
import java.util.List;

/**
 * Bean class for Bank.
 * 
 * @author Victor Angheluta.
 */
public class Bank {

    private String name;
    private List<String> accounts = new ArrayList<String>();
	
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<String> accounts) {
		this.accounts = accounts;
	}
}
