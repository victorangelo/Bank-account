package com.transact.dao;

import com.transact.model.bank.BankEntity;

/**
 * This interface designates a Data Access Object interface for a Bank.
 * 
 * @author Victor Angheluta
 */
public interface BankDAO {

	/**
	 * Gets a Bank by it's id.
	 * @param id
	 * @return BankEntity
	 */
	BankEntity getBankById(Integer id);
	
	/**
	 * Gets a bank by it's name. A Bank name is unique.
	 * @param name
	 * @return BankEntity
	 */
	BankEntity getBankByName(String name);
	
	/**
	 * Saves a Bank returning it's newly created id.
	 * @param bank
	 * @return Integer
	 */
	Integer saveBank(BankEntity bank);
}
