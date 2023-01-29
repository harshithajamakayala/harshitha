package com.training.app.repository.student;

import org.springframework.stereotype.Repository;

import com.training.app.entity.Course;
import com.training.app.entity.Student;
@Repository
public interface CustomStudentRepository {

	public Student updateCourseByStudent(Student student,Course course);
	
}
