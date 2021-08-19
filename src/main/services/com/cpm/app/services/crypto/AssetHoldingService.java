package com.cpm.app.services.crypto;

import java.util.List;

import com.cpm.app.core.crypto.entity.AssetHolding;

public interface AssetHoldingService {
	List<AssetHolding> findAll();
}
