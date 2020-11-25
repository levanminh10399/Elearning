package com.myclass.service.impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.myclass.dto.UserDto;
import com.myclass.entity.User;
import com.myclass.repository.UserRepository;
import com.myclass.service.UserService;

import ch.qos.logback.classic.spi.STEUtil;
import groovyjarjarasm.asm.tree.TryCatchBlockNode;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<UserDto> findAll() {
		List<UserDto> dtos = new ArrayList<UserDto>();
		List<User> users = userRepository.findAll();
		for (User user : users) {
			dtos.add(entityToDto(user));
		}
		return dtos;
	}

	private UserDto entityToDto(User entity) {
		return new UserDto(entity.getId(), entity.getEmail(), entity.getFullname(), entity.getPhone());
	}

	@Override
	public void addUser(UserDto userDto, ServletContext request) {
		// Kiểm tra tên tồn chưa
		// ...
		String filename = uploadFile(userDto, request);
		try {
			User user = new User(userDto.getEmail(), userDto.getFullname(), userDto.getPassword(), filename,
					userDto.getPhone(), userDto.getAddress(), userDto.getRole_id());
			userRepository.save(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String uploadFile(UserDto userDto, ServletContext request) {
		String uploadRootPath = request.getRealPath("");
		// System.out.println("real path: " + uploadRootPath);
		String savePath = uploadRootPath + "static/uploads";
		// System.out.println("savePath= " + savePath);

		File uploadRootDir = new File(savePath);

		if (!uploadRootDir.exists()) {
			uploadRootDir.mkdirs();
		}

		MultipartFile[] fileDatas = userDto.getMyUploadForm().getFileDatas();

		List<File> uploadedFiles = new ArrayList<File>();
		List<String> failedFiles = new ArrayList<String>();

		String name = "Rỗng";
		for (MultipartFile fileData : fileDatas) {
			name = fileData.getOriginalFilename();
			// System.out.println("Client File Name= " + name);
			if (name != null && name.length() > 0) {
				try {
					File serverFile = new File(uploadRootDir.getAbsoluteFile() + File.separator + name);
					BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
					stream.write(fileData.getBytes());
					stream.close();
					uploadedFiles.add(serverFile);
					System.out.println("Write file: " + serverFile);

				} catch (Exception e) {
					e.printStackTrace();
					failedFiles.add(name);
				}
			}
		}

		// System.out.println("Name: "+name);
		return name;

	}

	@Override
	public UserDto getById(int id) {
		return entityToDto(userRepository.findById(id).get());		
	}

}
