package com.transact.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.transact.model.transaction.TransactionEntity;

/**
 * This class designates a Data Access Object implementation for a Transaction persistent object.
 * 
 * @author Victor Angheluta
 */
@Repository
@Transactional
public class TransactionDAOImpl implements TransactionDAO {
	@PersistenceContext
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	@Override
	public List<TransactionEntity> getAllTransactions() {
		Query q = manager.createQuery("FROM TransactionEntity", TransactionEntity.class);
		return (List<TransactionEntity>) q.getResultList();
	}

	@Override
	public Integer saveTransaction(TransactionEntity transactionEntity) {
		manager.persist(transactionEntity);

		Query q = manager.createQuery(
				"FROM TransactionEntity WHERE sourceAccountID = :sAccountID AND destinationAccountID = :dAccountID AND date = :date",
				TransactionEntity.class);
		q.setParameter("sAccountID", transactionEntity.getSourceAccountID());
		q.setParameter("dAccountID", transactionEntity.getDestinationAccountID());
		q.setParameter("date", transactionEntity.getDate());
		@SuppressWarnings("unchecked")
		List<TransactionEntity> result = (List<TransactionEntity>) q.getResultList();
		if (result != null && result.size() > 0) {
			return result.get(0).getId();
		} else {
			return null;
		}
	}

}
