package com.usermanagement.service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.usermanagement.converter.RoleConverter;
import com.usermanagement.entity.Role;
import com.usermanagement.exception.ResourceNotFound;
import com.usermanagement.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.usermanagement.converter.UserConverter;
import com.usermanagement.dto.UserDto;
import com.usermanagement.entity.User;
import com.usermanagement.repository.UserRepository;
import org.springframework.web.client.ResourceAccessException;

@Service
public class UserService implements IUserService {

	@Autowired
	IValidation validation;

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserConverter userConverter;
	/*@Autowired
	private BCryptPasswordEncoder passwordEncoder;
*/
	@Autowired
	RoleRepository roleRepository;

	@Override
	public Map<String, String> validate(UserDto userDto) {
		Map<String, String> errorMap = new HashMap<>();

		if (!validation.validateUsername(userDto.getUsername())) {
			errorMap.put("userName", "error");
		}

		if (!validation.validatePhoneNumber(userDto.getPhoneNumber())) {
			errorMap.put("phoneNumber", "erroe");
		}

		if (!validation.validateEmail(userDto.getEmail())) {
			errorMap.put("email", "error");
		}

		{
			if (!validation.validatePassword(userDto.getPassword())) {
				errorMap.put("password", "erroe");
			}

			else if (!userDto.getPassword().equals(userDto.getConfirmPassword())) {
				errorMap.put("ConfimPassword", "erroe ");
			}
		}


			if (userDto.getRole() == null) {
				errorMap.put("role", "erroe ");
			}


		return errorMap;
	}

	@Override
	public boolean isPhoneNumberUnique(String phoneNumber) {

		Optional<User> optionalUser = userRepository.findByPhoneNumber(phoneNumber);
		if (optionalUser.isPresent()) {
			return false;
		}
		return true;
	}

	@Override
	public boolean isUsernameUnique(String username) {
		Optional<User> optionalUser = userRepository.findByUsername(username);
        return optionalUser.isEmpty();
    }

	@Override
	public boolean isEmailUnique(String email) {
		Optional<User> optionalUser = userRepository.findByEmail(email);
		if (optionalUser.isPresent()) {
			return false;
		}
		return true;
	}

	@Override
	public UserDto registerUser(UserDto userDto) throws ResourceNotFound {
		User user=userConverter.converToUser(userDto);
		//user.setPassword(passwordEncoder.encode(user.getPassword()));
		Optional<Role> role=roleRepository.findByRoleName(userDto.getRole());

		if(!role.isPresent()){
			throw  new ResourceNotFound("role not found");
		}

		user.setRole(role.get());
		user.setRegisteredTs(Timestamp.from(Instant.now()));

		userRepository.save(user);

		return userConverter.converToUserDTO(user);
	}

}
