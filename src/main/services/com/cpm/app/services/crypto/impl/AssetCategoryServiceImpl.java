package com.cpm.app.services.crypto.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpm.app.core.crypto.entity.AssetCategory;
import com.cpm.app.core.crypto.repository.AssetCategoryRepository;
import com.cpm.app.services.crypto.AssetCategoryService;

@Service
public class AssetCategoryServiceImpl implements AssetCategoryService{

	@Autowired
	AssetCategoryRepository assetCategoryRepository;
	@Override
	public List<AssetCategory> findAll() {
		
		return assetCategoryRepository.findAll();
	}

}
