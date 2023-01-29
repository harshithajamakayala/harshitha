package com.training.app.service.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.app.entity.Course;
import com.training.app.repository.course.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	CourseRepository courseRepository;

	@Override
	public Course addCourse(Course course) {
		// TODO Auto-generated method stub
		return courseRepository.save(course);
	}

	@Override
	public Course getCourseByName(String name) {
		// TODO Auto-generated method stub
		return courseRepository.getCourseByCourseName(name);
	}

	@Override
	public Course getCourseById(int id) {
		// TODO Auto-generated method stub
		return courseRepository.getReferenceById(id);
	}

	@Override
	public List<Course> getAllCourses() {
		// TODO Auto-generated method stub
		return courseRepository.findAll();
	}

	@Override
	public List<Course> getCoursesByCategory(String category) {
		// TODO Auto-generated method stub
		return courseRepository.getCourseByCategory(category);
	}

}
