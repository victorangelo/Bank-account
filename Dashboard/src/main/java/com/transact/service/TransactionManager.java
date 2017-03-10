package com.transact.service;

import java.util.List;

import com.transact.model.transaction.TransactionEntity;

/**
 * The Transaction Manager interface for a Transaction object.
 * 
 * @author Victor Angheluta
 */
public interface TransactionManager {

	/**
	 * Gets all transactions.
	 * @return List<TransactionEntity>
	 */
	public List<TransactionEntity> getAllTransactions();
	
	/**
	 * Saces a Transaction object returning it's newly created id.
	 * @param transactionEntity
	 * @return Integer
	 */
	public Integer saveTransaction(TransactionEntity transactionEntity);
}
