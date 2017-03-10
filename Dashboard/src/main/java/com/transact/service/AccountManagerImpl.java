package com.transact.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transact.dao.AccountDAO;
import com.transact.model.bank.AccountEntity;
import com.transact.model.bank.BankEntity;

/**
 * This class implements AccountManager interface.
 * 
 * @author Victor Angheluta
 */
@Service
public class AccountManagerImpl implements AccountManager {

	@Autowired
	AccountDAO dao;
	
	@Override
	public AccountEntity getAccountByID(Integer id) {
		return dao.getAccountByID(id);
	}

	@Override
	public AccountEntity getAccountByNumberAndBankId(String number, BankEntity bankID) {
		return dao.getAccountByNumberAndBankId(number, bankID);
	}

	@Override
	public Integer saveAccount(AccountEntity account) {
		return dao.saveAccount(account);
	}

	@Override
	public Integer update(AccountEntity account) {
		return dao.update(account);
	}

}
