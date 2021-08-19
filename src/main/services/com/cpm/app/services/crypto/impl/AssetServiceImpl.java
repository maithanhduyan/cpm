package com.cpm.app.services.crypto.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cpm.app.core.crypto.entity.Asset;
import com.cpm.app.core.crypto.repository.AssetRepository;
import com.cpm.app.services.crypto.AssetService;

@Service
public class AssetServiceImpl implements AssetService {

	@Autowired
	AssetRepository assetRepository;

	@Override
	public List<Asset> findAll() {
		return assetRepository.findAll();
	}

	@Override
	public Asset fetchById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Asset addOrUpdate(Asset asset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Asset> findPage(Pageable pageable) {
		return assetRepository.findAll(pageable);
	}

}
