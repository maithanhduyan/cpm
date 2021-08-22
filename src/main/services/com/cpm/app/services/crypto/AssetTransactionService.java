package com.cpm.app.services.crypto;

import java.util.List;

import com.cpm.app.core.crypto.entity.AssetTransaction;

public interface AssetTransactionService {
	List<AssetTransaction> findAll();
	List<AssetTransaction> findAllByAssetAndAccount(String assetCode, String account);
}
