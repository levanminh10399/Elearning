package com.myclass.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



import com.myclass.dto.RoleDto;
import com.myclass.dto.UserDto;
import com.myclass.service.RoleService;
import com.myclass.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String index(Model model) {
		List<UserDto> users = userService.findAll();
		model.addAttribute("users", users);
		return "user/index";
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add(Model model) {
		UserDto userDto = new UserDto();
		List<RoleDto> roleDtos = roleService.findAll();
		model.addAttribute("user", userDto);
		model.addAttribute("roles", roleDtos);
		return "user/add";
	}

	@Autowired
	ServletContext request;
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(@ModelAttribute("user") UserDto userDto) {	
		userService.addUser(userDto, request);
		return "redirect:/user";
	}


	@RequestMapping(value = "edit",method = RequestMethod.GET)
	public String edit(@RequestParam("id") int id, Model model) {
		model.addAttribute("user", userService.getById(id));
		return "user/edit";
	}
	
//	@RequestMapping(value = "edit",method = RequestMethod.POST)
//	public String edit(@RequestParam("id") int id, Model model) {
//		model.addAttribute("user", userService.getById(id));
//		return "user/edit";
//	}
}
