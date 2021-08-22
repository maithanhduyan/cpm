package com.cpm.app.core.crypto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cpm.app.core.crypto.entity.AssetTransaction;

public interface AssetTransactionRepository extends JpaRepository<AssetTransaction, String> {

	@Query(nativeQuery = false, value = "SELECT a FROM AssetTransaction a WHERE a.assetHolding.asset.name LIKE :assetName  AND a.assetHolding.account.userName=:username")
	List<AssetTransaction> findAllByAssetAndAccount(@Param("assetName") String assetName,@Param("username")  String username);
}