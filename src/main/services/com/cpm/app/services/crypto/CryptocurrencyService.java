package com.cpm.app.services.crypto;

import java.util.List;

import com.cpm.app.core.crypto.entity.Cryptocurrency;

public interface CryptocurrencyService {

	public List<Cryptocurrency> findAll();
}
