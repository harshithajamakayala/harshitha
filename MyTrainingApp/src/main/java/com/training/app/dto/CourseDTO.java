package com.training.app.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {
	
	private int id;
	private String courseName;
	private int duration;

}
