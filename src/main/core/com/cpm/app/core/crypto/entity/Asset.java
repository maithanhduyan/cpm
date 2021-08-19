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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ASSET")
@Data 
@Setter
@Getter
public class Asset implements Serializable {

	private static final long serialVersionUID = -5278102689775924319L;

	@Id
	@Column(name = "ID", unique = true, nullable = false)
	private String id;

	@Column(name = "CODE")
	private String code;

	@Column(name = "NAME", unique = true, nullable = false)
	private String name;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ASSET_CATEGORY_ID", foreignKey = @ForeignKey(name = "ASSET_CATEGORY_ID_FK"))
	private AssetCategory assetCategory;

	@Column(name = "CREATED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	@Column(name = "UPDATED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate;

}
