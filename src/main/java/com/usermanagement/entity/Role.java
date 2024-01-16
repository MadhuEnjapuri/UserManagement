package com.usermanagement.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "role")
@Entity
public class Role {
	// private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "role_id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roleId;
	
	@Column(name = "role_name", unique = true, nullable = false)
	private String roleName;
	
	@Column(name = "created_ts",nullable = false)
	private Timestamp roleCreatedTs;

}
