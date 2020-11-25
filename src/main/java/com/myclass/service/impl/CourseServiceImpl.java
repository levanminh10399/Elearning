package com.myclass.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.myclass.dto.CourseDto;
import com.myclass.entity.Course;
import com.myclass.repository.CourseRepository;
import com.myclass.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseRepository courseRepository;

	@Override
	public List<CourseDto> getPopularCourse() {
		Pageable pageable = PageRequest.of(0, 12);
		List<Course> courses = courseRepository.getPopularCourse(pageable);
		List<CourseDto> courseDtos = new ArrayList<CourseDto>();
		for (Course course : courses) {
			courseDtos.add(entityToDto(course));
		}
		return courseDtos;
	}

	@Override
	public List<CourseDto> getSaleOff() {
		
		return null;
	}

	private CourseDto entityToDto(Course course) {
		return new CourseDto(course.getId(), course.getTitle(), course.getImage(), course.getLetures_count(),
				course.getHour_count(), course.getView_count(), course.getPrice(), course.getDiscount(),
				course.getPromotion_price(), course.getDescription(), course.getContent());
	}
}
