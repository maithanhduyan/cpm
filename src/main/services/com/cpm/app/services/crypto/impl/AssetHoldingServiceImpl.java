package com.cpm.app.services.crypto.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpm.app.core.crypto.entity.AssetHolding;
import com.cpm.app.core.crypto.repository.AssetHoldingRepository;
import com.cpm.app.services.crypto.AssetHoldingService;
import com.cpm.app.services.crypto.AssetTransactionService;

@Service
public class AssetHoldingServiceImpl implements AssetHoldingService {

	@Autowired
	AssetTransactionService assetTransactionService;

	@Autowired
	AssetHoldingRepository assetHoldingRepository;

	@Override
	public List<AssetHolding> findAll() {
		return assetHoldingRepository.findAll();
	}

}
