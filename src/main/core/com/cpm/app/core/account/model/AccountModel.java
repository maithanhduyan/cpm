package com.cpm.app.core.account.model;

import com.cpm.app.core.account.entity.Account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountModel {
	private Account account;
	private String sessionId;
	
	
}
