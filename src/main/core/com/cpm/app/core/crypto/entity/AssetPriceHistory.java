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
import javax.persistence.ForeignKey;

@Entity
@Table(name = "ASSET_PRICE_HISTORY")
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

	public AssetPriceHistory() {
		super();
	}

	public AssetPriceHistory(String id, Asset asset, Date date, Double open, Double high, Double low, Double close,
			Double volumn, Date createdDate, Date updatedDate) {
		super();
		this.id = id;
		this.asset = asset;
		this.date = date;
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
		this.volumn = volumn;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Asset getAsset() {
		return asset;
	}

	public void setAsset(Asset asset) {
		this.asset = asset;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getOpen() {
		return open;
	}

	public void setOpen(Double open) {
		this.open = open;
	}

	public Double getHigh() {
		return high;
	}

	public void setHigh(Double high) {
		this.high = high;
	}

	public Double getLow() {
		return low;
	}

	public void setLow(Double low) {
		this.low = low;
	}

	public Double getClose() {
		return close;
	}

	public void setClose(Double close) {
		this.close = close;
	}

	public Double getVolumn() {
		return volumn;
	}

	public void setVolumn(Double volumn) {
		this.volumn = volumn;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Override
	public String toString() {
		return "AssetPriceHistory [id=" + id + ", asset=" + asset + ", date=" + date + ", open=" + open + ", high="
				+ high + ", low=" + low + ", close=" + close + ", volumn=" + volumn + ", createdDate=" + createdDate
				+ ", updatedDate=" + updatedDate + "]";
	}

}
