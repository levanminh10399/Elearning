package com.myclass.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myclass.dto.RoleDto;
import com.myclass.entity.Role;
import com.myclass.repository.RoleRepository;
import com.myclass.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	RoleRepository roleServiceImpl;
	
	@Override
	public List<RoleDto> findAll() {
		List<RoleDto> dtos = new ArrayList<RoleDto>();
		List<Role> roles = roleServiceImpl.findAll();
		for (Role role : roles) {
			dtos.add(new RoleDto(role.getId(), role.getName(), role.getDescription()));
		}
		return dtos;
	}

}
