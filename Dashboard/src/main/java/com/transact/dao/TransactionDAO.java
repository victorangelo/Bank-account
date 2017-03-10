package com.transact.dao;

import java.util.List;

import com.transact.model.transaction.TransactionEntity;

/**
 * The interface designates a Data Access Object for a Transaction.
 * 
 * @author Victor Angheluta
 */
public interface TransactionDAO {

	/**
	 * Gets the list of all transactions.
	 * @return List<TransactionEntity>
	 */ 
	List<TransactionEntity> getAllTransactions();
	
	/**
	 * Saves a Transaction returning it's newly created id.
	 * @param transactionEntity
	 * @return Integer
	 */
	Integer saveTransaction(TransactionEntity transactionEntity);
}
