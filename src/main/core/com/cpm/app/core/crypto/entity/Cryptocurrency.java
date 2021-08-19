package com.cpm.app.core.crypto.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Table(name = "CRYPTOCURRENCY")
@Data
public class Cryptocurrency implements Serializable {

	private static final long serialVersionUID = 4962764425995040985L;

	@Id
	@Column(name = "ID", unique = true, nullable = false)
	private String id;

	@Column(name = "CODE")
	private String code;

	@Column(name = "NAME", unique = true, nullable = false)
	private String name;

	@Column(name = "CREATED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	@Column(name = "UPDATED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate;

}
