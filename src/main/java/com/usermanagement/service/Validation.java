package com.usermanagement.service;

import org.springframework.stereotype.Service;

@Service
public class Validation implements IValidation {

	@Override
	public boolean validateUsername(String userName) {
		if(userName!=null && userName.matches(".{5,}")) {
			return true;
		}
		
		return false;
	}

	@Override
	public boolean validateEmail(String email) {
		String emailRegix="^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
		if(email!=null&&email.matches(emailRegix)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean validatePhoneNumber(String phoneNumber) {
		if(phoneNumber!=null && phoneNumber.matches("\\d{10}")) {
			return true;
		}
		return false;
	}

	@Override
	public boolean validatePassword(String password) {
		if(password!=null && password.matches(".{5,}")) {
			return true;
		}
		return false;
	}

}
