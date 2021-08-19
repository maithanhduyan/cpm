package com.cpm.app.core.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cpm.app.core.account.entity.Account;

public interface AccountRepository extends JpaRepository<Account, String> {

	@Query(value = "SELECT ac FROM Account ac WHERE ac.userName = :username AND ac.active = true")
	public Account findByUsername(@Param("username") String username);
}
