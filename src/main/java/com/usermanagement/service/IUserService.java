package com.usermanagement.service;

import java.util.Map;

import com.usermanagement.dto.UserDto;
import com.usermanagement.exception.ResourceNotFound;

public interface IUserService {
	
	public Map<String,String> validate(UserDto userDto);
	
	public boolean isPhoneNumberUnique(String phoneNumber);
	
	public boolean isUsernameUnique(String username);
	
	public boolean isEmailUnique(String email);
	
	public UserDto registerUser(UserDto userDto) throws ResourceNotFound;

}
