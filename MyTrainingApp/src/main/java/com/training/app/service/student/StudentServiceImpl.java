package com.training.app.service.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.app.entity.Course;
import com.training.app.entity.Student;
import com.training.app.repository.course.CourseRepository;
import com.training.app.repository.student.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
    
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	CourseRepository courseRepository;
	
	@Override
	public Student registerStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

	@Override
	public Student updateStudent(int studentCode, int courseId) {
		// TODO Auto-generated method stub
		Student savedStudent=studentRepository.getReferenceById(studentCode);
		Course savedCourse = courseRepository.getReferenceById(courseId);
		
		// if both instructor & course is available in database
				if(savedStudent != null & savedCourse != null) 
				{
					Student updatedStudent = studentRepository.updateCourseByStudent(savedStudent, savedCourse);
					studentRepository.save(updatedStudent); // if data is already saved then hibernate calls update query in background
					return updatedStudent;
				}
				
				else return null;
		
		
	}

	@Override
	public Student getStudentByName(String studentName) {
		// TODO Auto-generated method stub
		return studentRepository.getStudentByStudentName(studentName);
	}

	@Override
	public Student getStudentById(int stdId) {
		// TODO Auto-generated method stub
		return studentRepository.getReferenceById(stdId);
	}

	@Override
	public List<Student> getStudentsByDomain(String domain) {
		// TODO Auto-generated method stub
		return studentRepository.getStudentByDomain(domain);
	}

}
