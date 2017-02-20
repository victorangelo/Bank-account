package com.transact.dao;

import java.util.List;

import com.transact.model.transaction.TransactionsLogs;

/**
 * 
 * @author Victor Angheluta
 * 
 */
public interface ITransactionsLogs {
	
	public List<TransactionsLogs> getTransactions();
}
