package com.cpm.app.core.crypto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cpm.app.core.crypto.entity.AssetPriceHistory;

public interface AssetPriceHistoryRepository extends JpaRepository<AssetPriceHistory, String> {

}
