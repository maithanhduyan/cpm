package com.cpm.app.core.crypto.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

import javax.persistence.ForeignKey;

@Entity
@Table(name = "ASSET_PRICE_HISTORY")
@Data
public class AssetPriceHistory implements Serializable {

	private static final long serialVersionUID = -2194190221520221180L;

	@Id
	@Column(name = "ID", unique = true, nullable = false)
	private String id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ASSET_ID", nullable = false, foreignKey = @ForeignKey(name = "ASSET_ID_FK"))
	private Asset asset;

	@Column(name = "DATE")
	@Temporal(TemporalType.DATE)
	private Date date;

	@Column(name = "OPEN")
	private Double open;

	@Column(name = "HIGH")
	private Double high;

	@Column(name = "LOW")
	private Double low;

	@Column(name = "CLOSE")
	private Double close;

	@Column(name = "VOLUMN")
	private Double volumn;

	@Column(name = "CREATED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	@Column(name = "UPDATED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate;

}
