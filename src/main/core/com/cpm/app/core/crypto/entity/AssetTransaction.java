package com.cpm.app.core.crypto.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.ForeignKey;

import com.cpm.app.core.crypto.utils.TransactionType;

@Entity
@Table(name = "ASSET_TRANSACTION")
public class AssetTransaction implements Serializable {

	private static final long serialVersionUID = 1940904765998432228L;

	@Id
	@Column(name = "ID", unique = true, nullable = false)
	private String id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ASSET_ID", nullable = false, foreignKey = @ForeignKey(name = "ASSET_ID_FK"))
	private Asset asset;

	@Column(name = "PRICE")
	private double open;

	@Column(name = "QUANTITY")
	private double quantity;

	@Column(name = "FEE")
	private double fee;

	@Column(name = "COST")
	private double cost;

	@Column(name = "PROCEEDS")
	private double proceeds;

	@Column(name = "PROFIT")
	private double profit;

	@Enumerated(EnumType.ORDINAL)
	private TransactionType type;

	@Column(name = "NOTES")
	private String note;

	@Column(name = "CREATED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	@Column(name = "UPDATED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate;

	public AssetTransaction() {
	}

	public AssetTransaction(String id, Asset asset, double open, double quantity, double fee, double cost,
			double proceeds, double profit, TransactionType type, String note, Date createdDate, Date updatedDate) {
		super();
		this.id = id;
		this.asset = asset;
		this.open = open;
		this.quantity = quantity;
		this.fee = fee;
		this.cost = cost;
		this.proceeds = proceeds;
		this.profit = profit;
		this.type = type;
		this.note = note;
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

	public double getOpen() {
		return open;
	}

	public void setOpen(double open) {
		this.open = open;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public double getProceeds() {
		return proceeds;
	}

	public void setProceeds(double proceeds) {
		this.proceeds = proceeds;
	}

	public double getProfit() {
		return profit;
	}

	public void setProfit(double profit) {
		this.profit = profit;
	}

	public TransactionType getType() {
		return type;
	}

	public void setType(TransactionType type) {
		this.type = type;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
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
		return "AssetTransaction [id=" + id + ", asset=" + asset + ", open=" + open + ", quantity=" + quantity
				+ ", fee=" + fee + ", cost=" + cost + ", proceeds=" + proceeds + ", profit=" + profit + ", type=" + type
				+ ", note=" + note + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + "]";
	}

}
