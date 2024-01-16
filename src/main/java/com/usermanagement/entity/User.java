package com.usermanagement.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User implements Serializable {

	// private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "user_id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;

	@Column(name = "email", unique = true, nullable = false)
	private String email;

	@Column(name = "username", unique = true, nullable = false)
	private String username;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "phone_number", unique = true, nullable = false ,length=10)
	private String phoneNumber;

	@Column(name = "is_email_verified", nullable = false )
	private boolean isEmailVerified;

	@Column(name = "is_phone_number_verified", nullable = false)
	private boolean isPhoneNumberVerified;

	@Column(name = "is_account_locked", nullable = false)
	private boolean isAccountLocked;

	@Column(name = "email_verified_ts", nullable = true)
	private Timestamp emailVerifiedTs;

	@Column(name = "phone_number_verified_ts", nullable = true)
	private Timestamp phoneNumberVerifiedTs;

	@Column(name = "registered_ts", nullable = false)
	private Timestamp registeredTs;

	@Column(name = "updated_ts", nullable = true)
	private Timestamp updatedTs;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "role_id", nullable = false)
	private Role role;

	// uservrificaton
	// user profile
}
