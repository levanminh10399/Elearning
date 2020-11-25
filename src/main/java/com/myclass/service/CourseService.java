package com.myclass.service;

import java.util.List;

import com.myclass.dto.CourseDto;

public interface CourseService {
	List<CourseDto> getPopularCourse();
	List<CourseDto> getSaleOff();
}
