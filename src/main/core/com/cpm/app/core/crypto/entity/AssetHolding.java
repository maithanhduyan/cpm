package com.cpm.app.core.crypto.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "ASSET_HOLDING")
@Data
public class AssetHolding implements Serializable {

	private static final long serialVersionUID = -9050630320185748931L;
	@Id
	@Column(name = "ID", unique = true, nullable = false)
	private String id;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ASSET_ID", nullable = false, foreignKey = @ForeignKey(name = "ASSET_ID_FK"))
	private Asset asset;

	@Column(name = "HOLD")
	private double hold;

}
