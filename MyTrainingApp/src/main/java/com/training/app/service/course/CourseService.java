package com.training.app.service.course;

import org.springframework.stereotype.Service;
import com.training.app.entity.Course;
import java.util.List;

@Service
public interface CourseService {
	
	public Course addCourse(Course course);
	public Course getCourseByName(String name);
	public Course getCourseById(int id);
	public List<Course> getAllCourses();
	public List<Course> getCoursesByCategory(String category);
	
	
	

}
