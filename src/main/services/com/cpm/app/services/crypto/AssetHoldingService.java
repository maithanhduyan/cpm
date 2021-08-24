package com.cpm.app.services.crypto;

import java.util.List;

import com.cpm.app.core.crypto.entity.AssetHolding;

public interface AssetHoldingService {
	List<AssetHolding> findAll();
	AssetHolding fetchByUserNameAndAssetName(String username, String assetname);
	AssetHolding save(AssetHolding assetHolding);
}
