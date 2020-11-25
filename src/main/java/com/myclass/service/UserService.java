package com.myclass.service;

import java.util.List;

import javax.servlet.ServletContext;



import com.myclass.dto.UserDto;

public interface UserService {
	List<UserDto> findAll();
	void addUser(UserDto userDto, ServletContext request);
	UserDto getById(int id);
}
