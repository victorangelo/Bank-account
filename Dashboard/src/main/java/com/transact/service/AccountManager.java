package com.transact.service;

import com.transact.model.bank.AccountEntity;
import com.transact.model.bank.BankEntity;

/**
 * The Service Manager interface for an Account object.
 * 
 * @author Victor Angheluta
 */
public interface AccountManager {

	/**
	 * Gets an Account object by it's id.
	 * @param id
	 * @return AccountEntity
	 */
	AccountEntity getAccountByID(Integer id);
	
	/**
	 * Gets an Account object by it's Account number and it's Bank id.
	 * @param number
	 * @param bankID
	 * @return AccountEntity
	 */
	AccountEntity getAccountByNumberAndBankId(String number, BankEntity bankID);
	
	/**
	 * Saves an Account object returning it's id.
	 * @param account
	 * @return Integer
	 */
	Integer saveAccount(AccountEntity account);
	
	/**
	 * Updates an Accound object returning it's id.
	 * @param account
	 * @return Integer
	 */
	Integer update(AccountEntity account);
}
