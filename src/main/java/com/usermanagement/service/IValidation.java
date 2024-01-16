package com.usermanagement.service;

public interface IValidation {
	
	public boolean validateUsername(String userName);
	public boolean validateEmail(String email);
	public boolean validatePhoneNumber(String phoneNumber);
	public boolean validatePassword(String password);
	

}
