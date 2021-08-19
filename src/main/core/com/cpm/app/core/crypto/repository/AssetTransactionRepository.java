package com.cpm.app.core.crypto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cpm.app.core.crypto.entity.AssetTransaction;

public interface AssetTransactionRepository extends JpaRepository<AssetTransaction, String> {

}
