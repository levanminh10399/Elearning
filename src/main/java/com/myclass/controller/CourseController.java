package com.myclass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("course")
public class CourseController {
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String index() {
		return "course/index";
	}
	
	@RequestMapping(value = "add",method = RequestMethod.GET)
	public String add() {
		return "course/add";
	}
	
	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public String edit() {
		return "course/edit";
	}
}
