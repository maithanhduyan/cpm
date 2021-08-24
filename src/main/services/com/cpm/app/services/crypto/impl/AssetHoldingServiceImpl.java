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

	@Override
	public AssetHolding fetchByUserNameAndAssetName(String username, String assetname) {
		return assetHoldingRepository.fetchByUserNameAndAssetName(username, assetname);
	}

	@Override
	public AssetHolding save(AssetHolding assetHolding) {
		// TODO Auto-generated method stub
		return assetHoldingRepository.save(assetHolding);
	}

}
