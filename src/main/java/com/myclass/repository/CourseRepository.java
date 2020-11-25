package com.myclass.repository;


import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.myclass.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
	@Query("SELECT e FROM Course e ORDER BY e.view_count DESC")
	List<Course> getPopularCourse(Pageable pageable);
}
