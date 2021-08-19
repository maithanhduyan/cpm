package com.cpm.app.core.crypto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cpm.app.core.crypto.entity.AssetCategory;

public interface AssetCategoryRepository extends JpaRepository<AssetCategory, String> {

}
