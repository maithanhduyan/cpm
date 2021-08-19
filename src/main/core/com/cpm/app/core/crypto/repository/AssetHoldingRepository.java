package com.cpm.app.core.crypto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cpm.app.core.crypto.entity.AssetHolding;

public interface AssetHoldingRepository extends JpaRepository<AssetHolding, String> {

}
