package com.transact.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transact.dao.TransactionDAO;
import com.transact.model.transaction.TransactionEntity;

/**
 * This class implements TransactionManager interface.
 * 
 * @author Victor Angheluta
 */
@Service
public class TransactionManagerImpl implements TransactionManager {

	@Autowired
	TransactionDAO dao;

	@Override
	public List<TransactionEntity> getAllTransactions() {
		return dao.getAllTransactions();
	}

	@Override
	public Integer saveTransaction(TransactionEntity transactionEntity) {
		return dao.saveTransaction(transactionEntity);
	}

}
