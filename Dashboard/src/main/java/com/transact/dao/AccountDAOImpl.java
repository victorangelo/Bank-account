package com.transact.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.transact.model.bank.AccountEntity;
import com.transact.model.bank.BankEntity;

/**
 * This class designates the Data Access Object for an Account. Implements AccountDAO interface.
 * 
 * @author Victor Angheluta
 */
@Repository
@Transactional
public class AccountDAOImpl implements AccountDAO{


    @PersistenceContext
    private EntityManager manager;
    
	@Override
	public AccountEntity getAccountByID(Integer id) {
		Query q = manager.createQuery("FROM AccountEntity WHERE id = :id", AccountEntity.class);
		q.setParameter("id", id);
		@SuppressWarnings("unchecked")
		List<AccountEntity> result = (List<AccountEntity>)q.getResultList();
		if (result != null && result.size() > 0)
		{
			return result.get(0);
		}else {
			return null;
		}
	}

	@Override
	public AccountEntity getAccountByNumberAndBankId(String number, BankEntity bankID) {
		Query q = manager.createQuery("FROM AccountEntity WHERE bankID = :id AND number = :number", AccountEntity.class);
		q.setParameter("id", bankID);
		q.setParameter("number", number);
		@SuppressWarnings("unchecked")
		List<AccountEntity> result = (List<AccountEntity>)q.getResultList();
		if (result != null && result.size() > 0)
		{
			return result.get(0);
		}else {
			return null;
		}
	}

	@Override
	public Integer saveAccount(AccountEntity account) {
		manager.persist(account);
		
		Query q = manager.createQuery("FROM AccountEntity WHERE bankID = :id AND number = :number", AccountEntity.class);
		q.setParameter("id", account.getBankID());
		q.setParameter("number", account.getNumber());
		@SuppressWarnings("unchecked")
		List<AccountEntity> result = (List<AccountEntity>)q.getResultList();
		if (result != null && result.size() > 0)
		{
			return result.get(0).getId();
		}else {
			return null;
		}
	}

	@Override
	public Integer update(AccountEntity account) {
		manager.merge(account);
		
		Query q = manager.createQuery("FROM AccountEntity WHERE bankID = :id AND number = :number", AccountEntity.class);
		q.setParameter("id", account.getBankID());
		q.setParameter("number", account.getNumber());
		@SuppressWarnings("unchecked")
		List<AccountEntity> result = (List<AccountEntity>)q.getResultList();
		if (result != null && result.size() > 0)
		{
			return result.get(0).getId();
		}else {
			return null;
		}
	}

}
