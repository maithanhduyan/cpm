package com.cpm.app.core.crypto.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cpm.app.core.account.entity.Account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ASSET_HOLDING")
@Data
@AllArgsConstructor
@NoArgsConstructor
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

	@Column(name = "CREATED_DATE", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	@Column(name = "UPDATED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ACCOUNT_ID")
	private Account account;
	
	
}
