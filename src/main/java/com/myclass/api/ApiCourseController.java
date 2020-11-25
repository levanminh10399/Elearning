package com.myclass.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myclass.dto.CourseDto;
import com.myclass.service.CourseService;

@RestController
@RequestMapping("api/course")
public class ApiCourseController {
	@Autowired
	private CourseService courseService;
	
	@RequestMapping(value = "/getPopular", method = RequestMethod.GET)
	public Object get() {
		List<CourseDto> courseDtos = courseService.getPopularCourse();
		return new ResponseEntity<Object>(courseDtos, HttpStatus.OK);
	}
}
