package com.transact.service;

import com.transact.model.bank.BankEntity;

/**
 * The Bank Manager interface for a Bank object.
 * 
 * @author Victor Angheluta
 */
public interface BankManager {

	/**
	 * Gets a Bank object by it's id.
	 * @param id
	 * @return BankEntity
	 */
	BankEntity getBankById(Integer id);
	
	/**
	 * Gets a Bank object by it's name. A Bank name is unique
	 * @param name
	 * @return BankEntity
	 */
	BankEntity getBankByName(String name);
	
	/**
	 * Saves a Bank object returning it's newly created id.
	 * @param bank
	 * @return Integer
	 */
	Integer saveBank(BankEntity bank);
}
