package com.cpm.app.core.crypto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cpm.app.core.crypto.entity.Asset;

public interface AssetRepository extends JpaRepository<Asset, String> {

	@Query("SELECT a FROM Asset a WHERE a.name= :name")
	Asset findByName(@Param("name") String name);

	@Query("SELECT a FROM Asset a WHERE a.code = :code")
	Asset findByCode(@Param("code") String code);
}
