package com.transact.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.transact.model.transaction.TransactionsLogs;

/**
 * 
 * @author Victor Angheluta
 * 
 */
public class LogsDAO implements ITransactionsLogs {

	private SessionFactory sessionFactory;

	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}



	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



	@Override
	public List<TransactionsLogs> getTransactions() {

		@SuppressWarnings("unchecked")
		List<TransactionsLogs> list = getSessionFactory().getCurrentSession().createQuery("from transactionslogs").getResultList();
		
		return list;
	}
	
}
