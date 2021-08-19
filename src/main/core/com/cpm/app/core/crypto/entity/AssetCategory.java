package com.cpm.app.core.crypto.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "ASSET_CATEGORY")
@Data
public class AssetCategory {

	@Id
	@Column(name = "ID", nullable = false, unique = true)
	private String id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "DESCRIPTION")
	private String description;

}
