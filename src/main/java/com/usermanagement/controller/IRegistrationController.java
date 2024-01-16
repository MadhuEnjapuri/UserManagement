package com.usermanagement.controller;

import com.usermanagement.exception.ResourceNotFound;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.usermanagement.dto.UserDto;
//@validate
//@api
public interface IRegistrationController {
	
	
	//@apioperation
	//@api responces
	@PostMapping(value="/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> registerUser(@RequestBody UserDto userDto) throws ResourceNotFound;

}
