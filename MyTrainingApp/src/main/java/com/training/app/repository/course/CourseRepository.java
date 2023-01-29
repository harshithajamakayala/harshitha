package com.training.app.repository.course;



import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.training.app.entity.Course;

public interface CourseRepository extends JpaRepository<Course,Integer>{
	

	public Course getCourseByCourseName(String courseName);
	public List<Course> getCourseByCategory(String category);
}
