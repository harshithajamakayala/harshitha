package com.training.app.repository.student;

import org.springframework.stereotype.Repository;

import com.training.app.entity.Course;
import com.training.app.entity.Student;
@Repository
public class CustomStudentRepositoryImpl implements CustomStudentRepository {

	@Override
	public Student updateCourseByStudent(Student student, Course course) {
		// TODO Auto-generated method stub
		student.setCourse(course);
		
		return student;
	}

}
