package com.cpm.app.core.crypto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cpm.app.core.crypto.entity.Asset;

public interface AssetRepository extends JpaRepository<Asset, String>{

}
