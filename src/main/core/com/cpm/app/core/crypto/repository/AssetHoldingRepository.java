package com.cpm.app.core.crypto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cpm.app.core.crypto.entity.AssetHolding;

public interface AssetHoldingRepository extends JpaRepository<AssetHolding, String> {

	@Query("SELECT ah FROM AssetHolding ah WHERE ah.asset.id=:id")
	AssetHolding findByAsset(@Param("id") String id);
	
	@Query("SELECT ah FROM AssetHolding ah WHERE ah.account.userName=:username AND ah.asset.name=:assetname")
	AssetHolding fetchByUserNameAndAssetName(@Param("username") String username, @Param("assetname") String assetname);
}
