package com.transact.dao;

import com.transact.model.bank.AccountEntity;
import com.transact.model.bank.BankEntity;

/**
 * This interface designates the Data Access Object for an Account
 * 
 * @author Victor Angheluta
 */
public interface AccountDAO {

	/**
	 * Gets an Account by it's ID.
	 * @param id
	 * @return AccountEntity
	 */
	AccountEntity getAccountByID(Integer id);
	
	/**
	 * Gets a mapped DB Account by it's Account  number and Bank Id.
	 * @param number
	 * @param bankID
	 * @return AccountEntity
	 */
	AccountEntity getAccountByNumberAndBankId(String number, BankEntity bankID);
	
	/**
	 * Saves a mapped DB Account returning it's new id.
	 * @param account
	 * @return Integer
	 */
	Integer saveAccount(AccountEntity account);
	
	/**
	 * Updates a mapped DB Account object returning it's id.
	 * @param account
	 * @return Integer
	 */
	Integer update(AccountEntity account);
	
}
