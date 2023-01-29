package com.training.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.app.dto.StudentDTO;
import com.training.app.dto.StudentDTODefaultResponse;
import com.training.app.entity.Student;
import com.training.app.service.student.StudentService;
import com.training.app.util.StudentDTOConvertor;

@RestController
@RequestMapping("/student")
public class StudentRestController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
	@Autowired
	StudentService studentService;
	
	@Autowired
	StudentDTOConvertor studentDTOconvertor;
	
	public StudentRestController() {
		logger.info("student rest controller");
		System.err.println("student rest controller");
	}
	
	@PostMapping("/register")
	public ResponseEntity<StudentDTODefaultResponse> savedStudent(@RequestBody Student student){
		Student savedStudent = studentService.registerStudent(student);
		logger.info(" --->> Instructor saved "+savedStudent);
		
		StudentDTODefaultResponse dtoObj =studentDTOconvertor.convertTo(savedStudent) ;
		
		
		return new ResponseEntity<StudentDTODefaultResponse>(dtoObj,HttpStatus.OK);
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<StudentDTODefaultResponse>> getAllStudents()
	{
		List<Student> allStudentsInDB = studentService.getAllStudents();
		
		List<StudentDTODefaultResponse> dtoList = new ArrayList<>();
		for (Student student : allStudentsInDB) {
			
			StudentDTODefaultResponse dtoObj = studentDTOconvertor.convertTo(student);
			dtoList.add(dtoObj);
		}
		
		return new ResponseEntity<List<StudentDTODefaultResponse>>(dtoList,HttpStatus.OK);
	}
	@PutMapping("/{tid}/student/{cid}")
	public String updateTrainerWithCourse(@PathVariable int tid,@PathVariable int cid)
	{
		Student updatedStudent = studentService.updateStudent(tid, cid);
		
		if(updatedStudent.getCourse() != null)
		{
			return updatedStudent.toString();
		}
		else return "error : - "+updatedStudent.toString()+" ";
	}
	
	@GetMapping("/studentid/{id}")
	public ResponseEntity<StudentDTO> getStudentById(@PathVariable int id)
	{
		Student studentFromDB = studentService.getStudentById(id);
		
		StudentDTO obj=studentDTOconvertor.getStudentDTO(studentFromDB);
		
		return new ResponseEntity<StudentDTO>(obj,HttpStatus.OK);
	}
	
	@GetMapping("/student/name/{name}")
	public ResponseEntity<StudentDTO> getStudentByName(@PathVariable String name)
	{
		Student studentFromDB = studentService.getStudentByName(name);
		StudentDTO obj=studentDTOconvertor.getStudentDTO(studentFromDB);
		
		return new ResponseEntity<StudentDTO>(obj,HttpStatus.OK);
	}
	
	@GetMapping("/student/domain/{domain}")
	public ResponseEntity<List<StudentDTO>> getStudentByDomain(@PathVariable String domain)
	{
		List<Student> studentFromDB=studentService.getStudentsByDomain(domain);
		List<StudentDTO> allStudentDTO = new ArrayList<>();
		
		for (Student student : studentFromDB) {
			
			allStudentDTO.add(studentDTOconvertor.getStudentDTO(student));
			
		}
		
		return new ResponseEntity<List<StudentDTO>>(allStudentDTO,HttpStatus.OK);
	}
	
}
