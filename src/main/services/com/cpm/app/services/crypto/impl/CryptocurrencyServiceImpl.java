package com.cpm.app.services.crypto.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpm.app.core.crypto.entity.Cryptocurrency;
import com.cpm.app.core.crypto.repository.CryptocurrencyRepository;
import com.cpm.app.services.crypto.CryptocurrencyService;

@Service
public class CryptocurrencyServiceImpl implements CryptocurrencyService {

	@Autowired
	CryptocurrencyRepository cryptocurrencyRepository;

	@Override
	public List<Cryptocurrency> findAll() {
		// TODO Auto-generated method stub
		return cryptocurrencyRepository.findAll();
	}

}
