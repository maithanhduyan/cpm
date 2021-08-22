package com.cpm.app.services.auth;

import com.cpm.app.core.account.entity.Account;

public interface AccountService {
	Account findByName(String username);
}
