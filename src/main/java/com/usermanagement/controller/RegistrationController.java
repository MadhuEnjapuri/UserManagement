package com.usermanagement.controller;

import java.util.Map;

import com.usermanagement.exception.ResourceNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.usermanagement.dto.UserDto;
import com.usermanagement.service.IUserService;

@RestController
public class RegistrationController implements IRegistrationController {

	@Autowired
	IUserService userService;


	@Override
	public ResponseEntity<Object> registerUser(UserDto userDto) throws ResourceNotFound {

		Map<String, String> errorMap = userService.validate(userDto);

		if (!errorMap.isEmpty()) {
			return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
		}

		if (!userService.isEmailUnique(userDto.getEmail())) {
			errorMap.put("email", "duplicate email");
		}

		if (!userService.isPhoneNumberUnique(userDto.getPhoneNumber())) {
			errorMap.put("phoneNumber", "duplicate phone-number");
		}

		if (!userService.isUsernameUnique(userDto.getUsername())) {
			errorMap.put("username", "duplicate username");
		}
		
		if (!errorMap.isEmpty()) {
			return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(userService.registerUser(userDto), HttpStatus.OK);
	}

}
