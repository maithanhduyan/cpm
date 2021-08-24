package com.cpm.app.services.crypto;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cpm.app.core.crypto.entity.Asset;

public interface AssetService {

	public List<Asset> findAll();

	public Asset fetchById(String id);

	public Asset addOrUpdate(Asset asset);
	
	public Page<Asset> findPage(Pageable pageable);
	
	Asset findByName(String name);
}
