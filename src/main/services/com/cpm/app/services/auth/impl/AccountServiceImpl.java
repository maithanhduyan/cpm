package com.cpm.app.services.auth.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpm.app.core.account.entity.Account;
import com.cpm.app.core.account.repository.AccountRepository;
import com.cpm.app.services.auth.AccountService;

@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	AccountRepository accountRepository;
	@Override
	public Account findByName(String username) {
		return accountRepository.findByUsername(username);
	}

}
