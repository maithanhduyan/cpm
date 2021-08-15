package com.cpm.app.core.crypto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cpm.app.core.crypto.entity.Cryptocurrency;

public interface CryptocurrencyRepository extends JpaRepository<Cryptocurrency, String> {

}
