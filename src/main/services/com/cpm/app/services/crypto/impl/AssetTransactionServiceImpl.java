package com.cpm.app.services.crypto.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpm.app.core.crypto.entity.AssetTransaction;
import com.cpm.app.core.crypto.repository.AssetTransactionRepository;
import com.cpm.app.services.crypto.AssetTransactionService;

@Service
public class AssetTransactionServiceImpl implements AssetTransactionService {

	@Autowired
	AssetTransactionRepository assetTransactionRepository;

	@Override
	public List<AssetTransaction> findAll() {
		return assetTransactionRepository.findAll();
	}

}
