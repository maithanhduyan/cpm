package com.cpm.app.core.account.entity;

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
@Entity
@Table(name = "ACCOUNT")
@AllArgsConstructor
@NoArgsConstructor
public class Account implements Serializable {

	private static final long serialVersionUID = -1656714216264469124L;

	public static final String ROLE_ADMIN = "ADMIN";
	public static final String ROLE_MANAGER = "MANAGER";
	public static final String ROLE_EMPLOYEE = "EMPLOYEE";

	@Id
	@Column(name = "ID")
	private String id;

	@Column(name = "USER_NAME", nullable = false, unique = true)
	private String userName;

	@Column(name = "ENCRYTED_PASSWORD", length = 128, nullable = false)
	private String encrytedPassword;

	@Column(name = "ACTIVE", length = 1, nullable = false)
	private boolean active;

	@Column(name = "CREATED_DATE", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	@Column(name = "UPDATED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate;

	@Column(name = "USER_ROLE", length = 20, nullable = false)
	private String userRole;
}
