package com.usermanagement.converter;

import com.usermanagement.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.usermanagement.dto.roleDto;
import com.usermanagement.entity.Role;

@Component
public class RoleConverter {
	@Autowired
	RoleRepository roleRepository;


	public roleDto convertToroleDto(Role role) {
		roleDto roleDto = new roleDto();
		roleDto.setRolename(role.getRoleName());

		return roleDto;

	}

	public Role convertToRole(roleDto roledto) {
		Role role = new Role();

		role.setRoleName(roledto.getRolename());

		return role;
	}
}
