package com.usermanagement.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.usermanagement.dto.UserDto;
import com.usermanagement.entity.User;

@Component
public class UserConverter {
	@Autowired
	RoleConverter roleConverter;

	public UserDto converToUserDTO(User user) {

		UserDto userdto = new UserDto();

		userdto.setUsername(user.getUsername());
		userdto.setEmail(user.getEmail());
		userdto.setPhoneNumber(user.getPhoneNumber());
		userdto.setRole(user.getRole().getRoleName());
		//userdto.getRoleDto().setRolename(user.getRole().getRoleName());
		userdto.setPassword(user.getPassword());
		//userdto.setConfirmPassword();

		return userdto;

	}

	public User converToUser(UserDto userdto) {

		User user = new User();
		user.setUsername(userdto.getUsername());
		user.setEmail(userdto.getEmail());
		user.setPhoneNumber(userdto.getPhoneNumber());
		user.setPassword(userdto.getPassword());
		
		//user.setRole(roleConverter.convertToRole(userdto.getRoleDto()));
		
		//user.getRole().setRoleName(userdto.getRoleDto().getRolename());

		return user;

	}

}
