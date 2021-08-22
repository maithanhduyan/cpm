package com.cpm.app.services.crypto;

import java.util.List;

import com.cpm.app.core.crypto.entity.AssetPriceHistory;

public interface AssetPriceHistoryService {

	List<AssetPriceHistory> findAll();
}
