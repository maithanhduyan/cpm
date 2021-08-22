package com.cpm.app.core.crypto.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ASSET_PRICE_HISTORY")
public class AssetPriceHistory implements Serializable {

	private static final long serialVersionUID = -2194190221520221180L;

	@Id
	@Column(name = "ID", unique = true, nullable = false)
	private String id;

	@Column(name = "PAIR")
	private String pair;

	@Column(name = "DATE")
	@Temporal(TemporalType.DATE)
	private Date date;

	@Column(name = "OPEN")
	private double open;

	@Column(name = "HIGH")
	private double high;

	@Column(name = "LOW")
	private double low;

	@Column(name = "CLOSE")
	private double close;

	@Column(name = "ADJ_CLOSE")
	private Double adjClose;

	@Column(name = "VOLUME")
	private double volume;

	@Column(name = "CREATED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	@Column(name = "UPDATED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate;

}
