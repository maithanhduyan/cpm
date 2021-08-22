package com.cpm.app.services.crypto.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpm.app.core.crypto.entity.AssetPriceHistory;
import com.cpm.app.core.crypto.repository.AssetPriceHistoryRepository;
import com.cpm.app.services.crypto.AssetPriceHistoryService;

@Service
public class AssetPriceHistoryServiceImpl implements AssetPriceHistoryService{

	@Autowired
	AssetPriceHistoryRepository assetPriceHistoryRepository;
	@Override
	public List<AssetPriceHistory> findAll() {
		return assetPriceHistoryRepository.findAll();
	}

}
