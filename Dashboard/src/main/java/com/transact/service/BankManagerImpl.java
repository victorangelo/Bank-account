package com.transact.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transact.dao.BankDAO;
import com.transact.model.bank.BankEntity;

/**
 * This class implements BankManager interface.
 * 
 * @author Victor Angheluta
 */
@Service
public class BankManagerImpl implements BankManager{

	@Autowired
	BankDAO dao;
	
	@Override
	public BankEntity getBankById(Integer id) {
		return dao.getBankById(id);
	}
	
	@Override
	public BankEntity getBankByName(String name) {
		return dao.getBankByName(name);
	}

	@Override
	public Integer saveBank(BankEntity bank) {
		return dao.saveBank(bank);
	}
}
