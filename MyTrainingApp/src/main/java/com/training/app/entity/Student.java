package com.training.app.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "AppStudent")
@Data
@NoArgsConstructor
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int stdCode;
	@Column(name="StudentName")
	private String studentName;
	private String domain;
	
	@Embedded
	@Column(nullable = true)
	private Profile profile;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Course course;

	public Student(String studentName, String domain, Profile profile) {
		super();
		this.studentName = studentName;
		this.domain = domain;
		this.profile = profile;
	}

	



	
}
