package com.cpm.app.core.account.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "COMPANY")
public class Company implements Serializable {

	private static final long serialVersionUID = 7378632452380794922L;

	@Id
	@Column(name = "ID")
	private String id;

	@Column(name = "NAME", nullable = false)
	private String name;

	@Column(name = "BRAND_NAME", nullable = false)
	private String brandName;

	@Column(name = "ACTIVE", length = 1, nullable = false)
	private boolean active;

}
