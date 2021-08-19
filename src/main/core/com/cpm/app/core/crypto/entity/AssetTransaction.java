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

@Data
@Entity
@Table(name = "ASSET_TRANSACTION")
public class AssetTransaction implements Serializable {

	private static final long serialVersionUID = 1940904765998432228L;

	@Id
	@Column(name = "ID")
	private  String id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ASSET_HOLDING_ID")
	private AssetHolding assetHolding;

	@Column(name = "PRICE")
	private double price;

	@Column(name = "NOTES")
	private String note;

	@Column(name = "CREATED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	@Column(name = "UPDATED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate;



	
}
