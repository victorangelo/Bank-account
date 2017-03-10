package com.transact.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.transact.model.bank.BankEntity;

/**
 * This class designates the Data Access Object implementation for a Bank persistent object.
 * 
 * @author Victor Angheluta
 */
@Repository
@Transactional
public class BankDAOImpl implements BankDAO{

    @PersistenceContext
    private EntityManager manager;
    
	@Override
	public BankEntity getBankById(Integer id) {
		Query q = manager.createQuery("FROM BankEntity WHERE id = :id", BankEntity.class);
		q.setParameter("id", id);
		@SuppressWarnings("unchecked")
		List<BankEntity> result = (List<BankEntity>)q.getResultList();
		if (result != null && result.size() > 0)
		{
			return result.get(0);
		}else {
			return null;
		}
	}
	
	@Override
	public BankEntity getBankByName(String name) {
		Query q = manager.createQuery("FROM BankEntity WHERE name = :name", BankEntity.class);
		q.setParameter("name", name);
		@SuppressWarnings("unchecked")
		List<BankEntity> result = (List<BankEntity>)q.getResultList();
		if (result != null && result.size() > 0)
		{
			return result.get(0);
		}else {
			return null;
		}
	}

	
	/**
	 * returns the ID of the newly saved BankEntity object
	 * @param bank
	 * @return
	 */
	public Integer saveBank(BankEntity bank){
		manager.persist(bank);
		
		Query q = manager.createQuery("FROM BankEntity WHERE name = :name", BankEntity.class);
		q.setParameter("name", bank.getName());
		@SuppressWarnings("unchecked")
		List<BankEntity> result = (List<BankEntity>)q.getResultList();
		if (result != null && result.size() > 0)
		{
			return result.get(0).getId();
		}else {
			return null;
		}
	}
}
