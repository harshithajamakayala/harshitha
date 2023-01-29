package com.training.app.service.student;

import java.util.List;

import org.springframework.stereotype.Service;


import com.training.app.entity.Student;

@Service
public interface StudentService {
	
	public Student registerStudent(Student student);
	public List<Student> getAllStudents();
	public Student updateStudent(int studentCode,int courseId);
	public Student getStudentByName(String studentName);
	public Student getStudentById(int stdId);
	public List<Student> getStudentsByDomain(String domain);
	

}
